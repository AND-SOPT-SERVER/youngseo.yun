package org.sopt.seminar1;

import java.util.List;
import org.sopt.seminar1.DiaryRepository;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    // 일기 작성
    void writeDiary(final String body) {
        // 클라이언트에서 온 값을 diary로 만들어서 저장을 명령함
        final Diary diary = new Diary(null, body);
        diaryRepository.save(diary); // 레포지토리에 넘겨만 줌
    }

    // 일기 목록 조회
    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    // 일기 삭제
    boolean deleteDiary(final Long id) {
        return diaryRepository.deleteById(id);
    }

    // 일기 수정
    boolean updateDiary(final Long id, final String newBody) {
        return diaryRepository.updateById(id, newBody);
    }
}

// 컨트롤러 > 서비스 > 레포지토리 > 디비저장