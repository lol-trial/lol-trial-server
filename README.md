## 👨‍💻Git work-flow
1. main브랜치에서는 작업 일체 금지X
2. 작업을 시작할 때는 **develop브랜치에서 분기**한 **feature브랜치를 생성**하여 작업할 것(브랜치 명 예시: feature/작업명)
3. 작업이 완료되면 feature브랜치에서 develop브랜치로 squash and merge 전략을 사용하여 PULL REQUEST할 것(완료 후 feature 브랜치 삭제)
4. 배포를 할 때는 develop 브랜치에서 main브랜치로 merge하고, tag나 release등을 남겨서 메모한다.
