package org.sopt.seminar1;

import java.time.LocalDateTime;

public class Diary {
    private Long id;
    private String body;
    private LocalDateTime lastModified;  // 마지막 수정 시간
    private int modificationCount;       // 하루에 몇 번 수정했는지 기록

    public Diary(Long id, String body) {
        this.id = id;
        this.body = body;
        this.lastModified = LocalDateTime.now(); // 생성 시점을 기록
        this.modificationCount = 0; // 처음엔 수정 횟수 0
    }

    // id 설정 메서드
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public int getModificationCount() {
        return modificationCount;
    }

    // 일기 내용을 수정하는 메서드 (수정 횟수와 시간도 업데이트)
    public void updateBody(String newBody) {
        this.body = newBody;
        this.lastModified = LocalDateTime.now(); // 수정 시간 업데이트
        this.modificationCount += 1; // 수정 횟수 증가
    }

    // 하루가 지났는지 확인하고, 하루가 지났다면 수정 횟수를 초기화
    public void resetModificationCountIfNeeded() {
        LocalDateTime now = LocalDateTime.now();
        if (lastModified.toLocalDate().isBefore(now.toLocalDate())) {
            modificationCount = 0; // 새로운 날이 시작되면 수정 횟수 초기화
        }
    }
}