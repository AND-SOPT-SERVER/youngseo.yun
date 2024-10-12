package org.sopt.seminar1;

import java.util.List;
import org.sopt.seminar1.DiaryRepository;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();
    private static final int MAX_BODY_LENGTH = 30; // 일기 최대 글자수 제한
    private static final int MAX_MODIFICATION_COUNT = 2; // 하루 최대 수정 횟수

    // 일기 작성
    void writeDiary(final String body) {
        if (body.length() > MAX_BODY_LENGTH) {
            throw new IllegalArgumentException("일기 내용은 30자를 초과할 수 없습니다.");
        }
        final Diary diary = new Diary(null, body);
        diaryRepository.save(diary); // 레포지토리에 저장
    }

    // 일기 목록 조회
    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    // 일기 삭제
    boolean deleteDiary(final Long id) {
        return diaryRepository.deleteById(id);
    }

    // 일기 수정 (글자수 제한 및 하루 2번 수정 제한)
    boolean updateDiary(final Long id, final String newBody) {
        // 글자 수 제한 검사
        if (newBody.length() > MAX_BODY_LENGTH) {
            throw new IllegalArgumentException("일기 내용은 30자를 초과할 수 없습니다.");
        }

        // 일기 조회
        Diary diary = diaryRepository.findById(id);

        if (diary != null) {
            // 하루가 지났으면 수정 횟수 초기화
            diary.resetModificationCountIfNeeded();

            // 수정 횟수 확인
            if (diary.getModificationCount() < MAX_MODIFICATION_COUNT) {
                // 수정 가능, 일기 내용 업데이트 및 수정 횟수 증가
                diaryRepository.updateById(id, newBody);
                System.out.println("일기 ID: " + id + " 수정 횟수: " + (diary.getModificationCount()));
                return true;
            } else {
                System.out.println("일기 ID: " + id + " 수정 불가 (하루에 2번 초과)");
                return false; // 수정 횟수 초과
            }
        }
        return false; // 일기가 존재하지 않을 경우
    }
}

// 컨트롤러 > 서비스 > 레포지토리 > 디비저장