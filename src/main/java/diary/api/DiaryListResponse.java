package diary.api;

import java.util.List;

public class DiaryListResponse {
    private List<DiaryResponse> diaryList;

    public DiaryListResponse(List<DiaryResponse> diaryResponseList) {
        this.diaryList = diaryResponseList;
    }

    public List<DiaryResponse> getDiaryList() {
        return diaryList;
    }
}
