package nextstep.subway.section.ui;

import nextstep.subway.line.application.LineService;
import nextstep.subway.line.dto.LineResponse;
import nextstep.subway.section.dto.SectionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectionController {

    private final LineService lineService;

    public SectionController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping(value = "/lines/{lineId}/sections")
    public ResponseEntity<LineResponse> registerSections(
            @PathVariable Long lineId,
            @RequestBody SectionRequest request
    ) {
        return ResponseEntity.ok(LineResponse.of(lineService.addSection(lineId, request)));
    }

    @DeleteMapping(value = "/lines/{lineId}/sections/{sectionId}")
    public ResponseEntity<LineResponse> deleteSection(
            @PathVariable Long lineId,
            @PathVariable Long sectionId,
            @RequestBody SectionRequest request
    ) {
        //TODO
        return null;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<LineResponse> handleIllegalArgsException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }

//    @ExceptionHandler(NotFoundEntity.class)
//    public ResponseEntity<LineResponse> handleNotFoundException(NotFoundEntity e) {
//        return ResponseEntity.badRequest().build();
//    }
}