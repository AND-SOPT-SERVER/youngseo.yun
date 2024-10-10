package org.sopt.seminar1;

import java.util.List;

public class DiaryController {
    private Status status = Status.READY;
    private final DiaryService diaryService = new DiaryService();

    Status getStatus() {
        return status;
    }

    void boot() {
        this.status = Status.RUNNING;
    }

    void finish() {
        this.status = Status.FINISHED;
    }

    // APIS
    final List<Diary> getList() {
        return diaryService.getDiaryList();
    }

    final void post(final String body) {
        // 여기서 올바른 값이 들어왔는지 필터도 가능
        diaryService.writeDiary(body);
    }

    final void delete(final String id) {
        Long diaryId = Long.parseLong(id); // str을 long으로 반환
        boolean success = diaryService.deleteDiary(diaryId);
        if (!success) {
            throw new RuntimeException("해당 ID의 일기를 찾을 수 없습니다.");
        }
    }

    final void patch(final String id, final String body) {
        Long diaryId = Long.parseLong(id); // str을 long으로 반환
        boolean success = diaryService.updateDiary(diaryId, body);
        if (!success) {
            throw new RuntimeException("해당 ID의 일기를 찾을 수 없습니다.");
        }
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}