package org.sopt.seminar1;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// 디비와 커넥션을 하는 역할이 레포지토리

public class DiaryRepository {
    private final Map<Long, Diary> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    // 일기 저장 메서드
    void save(final Diary diary) {
        // 채반 과정
        final long id = numbering.addAndGet(1); // ID 자동 증가
        diary.setId(id); // Diary 객체에 ID 설정

        // 저장 과정
        storage.put(id, diary); // 이게 원래 디비의 역할
    }

    // 모든 일기 조회 메서드
    List<Diary> findAll() {
        final List<Diary> diaryList = new ArrayList<>();

        for (long index = 1; index <= numbering.longValue(); index++) {
            Diary diary = storage.get(index);
            if (diary != null) {
                diaryList.add(diary);
            }
        }
        return diaryList;
    }

    // ID로 일기 삭제 메서드
    boolean deleteById(final long id) {
        return storage.remove(id) != null; // ID로 삭제, 성공하면 true 반환
    }

    // ID로 일기 수정 메서드 (수정 횟수 및 글자 수 제한은 Service에서 처리)
    boolean updateById(final long id, final String newBody) {
        Diary diary = storage.get(id);
        if (diary != null) {
            diary.updateBody(newBody); // 일기 내용 수정
            return true;
        }
        return false; // ID에 해당하는 일기가 없는 경우
    }

    // ID로 일기 검색 메서드
    Diary findById(final long id) {
        return storage.get(id); // 저장된 일기 반환
    }
}
