package diary.service;

import diary.repository.DiaryEntity;
import diary.repository.DiaryRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class DiaryService {
    private final DiaryRepository diaryRepository; // db를 가져오는 행위를 정의

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    // 일기 생성
    public void createDiary() {
        diaryRepository.save(new DiaryEntity("빵서"));
    }

    // 일기 조회
    public List<Diary> getList() {
        // 1 | repository로부터 DiaryEntity를 가져옴
        final List<DiaryEntity> diaryEntityList = diaryRepository.findAll();

        // 2 | DiaryEntity를 Diary로 변환해주는 작업
        final List<Diary> diaryList = new ArrayList<>();

        for(DiaryEntity diaryEntity : diaryEntityList) {
            diaryList.add(
                    new Diary(diaryEntity.getId(), diaryEntity.getName())
            );
        }

        return diaryList;
    }
}
