package org.sopt.seminar1;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// 디비와 커넥션을 하는 역할이 레포지토리

public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    // 일기 저장 메서드
    void save(final Diary diary) {
        // 채반 과정
        final long id = numbering.addAndGet(1);
        // 저장 과정
        storage.put(id, diary.getBody()); // 이게 원래 디비의 역할
    }

    // 모든 일기 조회 메서드
    List<Diary> findAll() {
        // 1 | diary 담을 자료구조
        final List<Diary> diaryList = new ArrayList<>();

        // 2 | 저장한 값을 불러오는 반복 구조
        for(long index = 1; index <= numbering.longValue(); index++) {
            final String body = storage.get(index);
            // 2-1 | 불러온 값을 구성한 자료구조로 이관
            diaryList.add(new Diary(index, body));
        }

        // 3 | 불러온 자료구조를 응답
        return diaryList;
    }

    // ID로 일기 삭제 메서드
    boolean deleteById(final long id) {
        return storage.remove(id) != null; // ID로 삭제, 성공하면 true 반환
    }

    // ID로 일기 수정 메서드
    boolean updateById(final long id, final String newBody) {
        if (storage.containsKey(id)) {
            storage.put(id, newBody);
            return true;
        }
        return false;
    }
}
