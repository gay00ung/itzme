# 🎯 ITZME 프로젝트 완전 분석 가이드

## 📚 목차
1. [프로젝트 개요](#프로젝트-개요)
2. [기술 스택 이해하기](#기술-스택-이해하기)
3. [프로젝트 구조 분석](#프로젝트-구조-분석)
4. [코드 동작 방식](#코드-동작-방식)
5. [빌드 및 배포 프로세스](#빌드-및-배포-프로세스)
6. [트러블슈팅 히스토리](#트러블슈팅-히스토리)

---

## 🌟 프로젝트 개요

### 이게 뭐야?
- **Kotlin/JS** 기반 웹 포트폴리오 사이트
- **Kobweb** 프레임워크로 만든 정적 사이트
- **Jetpack Compose for Web** 사용 (Android Compose랑 비슷한 문법!)
- **사이버펑크** 테마의 개발자 포트폴리오

### 왜 이 기술들을 쓰는거야?
```
Kotlin → JavaScript 변환 → 웹브라우저에서 실행
   ↓
Android 개발자가 웹 개발을 쉽게!
   ↓
Compose 문법 그대로 사용 가능!
```

---

## 🛠 기술 스택 이해하기

### 1. Kobweb이 뭐야?
```kotlin
// Kobweb = Kotlin + Web
// React의 Next.js 같은 존재!

특징:
- 파일 기반 라우팅 (pages 폴더의 파일 = URL 경로)
- 정적 사이트 생성 (SSG)
- Live Reload 개발 서버
- Silk UI 라이브러리 포함
```

### 2. Kotlin/JS가 뭐야?
```kotlin
// Kotlin 코드 → JavaScript로 컴파일

예시:
Kotlin: fun hello() = "Hello"
   ↓ 컴파일
JavaScript: function hello() { return "Hello"; }
```

### 3. Compose for Web이 뭐야?
```kotlin
// Android Compose와 똑같은 문법!

@Composable
fun MyComponent() {
    Box(Modifier.fillMaxSize()) {
        Text("Hello Web!")
    }
}
```

---

## 📁 프로젝트 구조 분석

### 전체 구조
```
itzme/
├── 🔧 설정 파일들
│   ├── build.gradle.kts         # 메인 빌드 설정
│   ├── settings.gradle.kts      # 프로젝트 설정
│   └── gradle.properties        # Gradle 속성
│
├── 🌐 site/                    # 웹사이트 모듈
│   ├── build.gradle.kts        # 사이트 빌드 설정
│   └── src/jsMain/             # Kotlin/JS 소스
│       ├── kotlin/             # Kotlin 코드
│       └── resources/          # 리소스 (폰트, CSS 등)
│
├── 🚀 .github/workflows/       # CI/CD
│   └── deploy.yml              # GitHub Actions 배포 스크립트
│
└── 📦 배포 관련
    └── vercel.json             # Vercel 설정
```

### site 모듈 상세 구조
```
site/src/jsMain/kotlin/net/ifmain/itzme/
├── 📄 AppEntry.kt              # 앱 진입점 (main 같은거)
├── 📁 pages/                   # 페이지들 (URL 경로)
│   ├── Index.kt                # / (메인 페이지)
│   ├── Home.kt                 # 홈 섹션 컴포넌트
│   ├── About.kt                # /about 페이지
│   ├── Work.kt                 # /work 페이지
│   └── Contact.kt              # /contact 페이지
└── 📁 components/              # 재사용 컴포넌트
    ├── PageLayout.kt           # 공통 레이아웃
    ├── AnimatedBackground.kt   # 애니메이션 배경
    ├── ModernStyles.kt         # 스타일 정의
    └── ProfileStyles.kt        # 프로필 스타일
```

---

## 💻 코드 동작 방식

### 1. 앱 시작점 (AppEntry.kt)
```kotlin
@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        // 글로벌 스타일 설정
        // 폰트, 배경색 등
        content()  // 페이지 렌더링
    }
}
```

### 2. 라우팅 시스템
```kotlin
// Kobweb의 파일 기반 라우팅

pages/Index.kt    → /          (메인 페이지)
pages/About.kt    → /about     (소개 페이지)
pages/Work.kt     → /work      (작업 페이지)
pages/Contact.kt  → /contact   (연락처 페이지)

// @Page 어노테이션이 핵심!
@Page("/about")  // 이 경로로 접근 가능
@Composable
fun AboutPage() { ... }
```

### 3. 페이지 구조 예시 (Home.kt)
```kotlin
// 1️⃣ 애니메이션 정의
val GlitchAnimation = Keyframes {
    // 글리치 효과 키프레임
}

// 2️⃣ 페이지 컴포넌트
@Composable
fun HomePage() {
    PageLayout(currentSection = 0) {  // 공통 레이아웃 사용
        heroSection()  // 실제 콘텐츠
    }
}

// 3️⃣ 섹션 구현
@Composable
fun heroSection() {
    Box {
        // 배경 효과
        // 텍스트 "ANDROID DEVELOPER"
        // 코드 블록 시각화
    }
}
```

### 4. 공통 레이아웃 (PageLayout.kt)
```kotlin
@Composable
fun PageLayout(
    currentSection: Int,  // 현재 활성 섹션
    content: @Composable () -> Unit
) {
    Box {
        TopNavBar(currentSection)  // 상단 네비게이션
        Box(Modifier.padding(top = 80.px)) {
            content()  // 페이지별 콘텐츠
        }
    }
}

// 네비게이션 바
@Composable
fun TopNavBar(currentSection: Int) {
    Row {
        // 로고: "Hello! I'm Gayoung!"
        // 메뉴: HOME | ABOUT | WORK | CONTACT
        NavItem("HOME", "/", currentSection == 0)
        NavItem("ABOUT", "/about", currentSection == 1)
        // ...
    }
}
```

### 5. 스타일링 방식
```kotlin
// 1️⃣ Modifier 체이닝
Modifier
    .fillMaxSize()
    .background(Color("#000000"))
    .padding(100.px)

// 2️⃣ styleModifier로 CSS 직접 적용
Modifier.styleModifier {
    property("font-family", "'JetBrains Mono', monospace")
    property("letter-spacing", "4px")
    property("text-shadow", "0 0 30px rgba(0, 255, 255, 0.5)")
}

// 3️⃣ 애니메이션
Modifier.animation(GlitchAnimation.toAnimation(3.s))
```

### 6. 컴포넌트 재사용 예시
```kotlin
// 기술 태그 컴포넌트
@Composable
fun techTag(text: String) {
    Box(
        Modifier
            .padding(12.px, 24.px)
            .border(1.px, LineStyle.Solid, Color("#00ffff"))
    ) {
        SpanText(text)  // KOTLIN, COMPOSE 등
    }
}

// 사용
Row {
    techTag("KOTLIN")
    techTag("COMPOSE")
    techTag("ANDROID")
}
```

---

## 🚀 빌드 및 배포 프로세스

### 1. 로컬 개발
```bash
# 개발 서버 시작
cd site
kobweb run

# 또는
./gradlew :site:kobwebStart

# → http://localhost:8080 에서 확인
# → 코드 수정하면 자동 새로고침!
```

### 2. 빌드 과정
```bash
./gradlew :site:kobwebExport

이 명령어가 하는 일:
1. Kotlin → JavaScript 컴파일
2. HTML, CSS, JS 번들링
3. 정적 파일 생성
4. site/.kobweb/site/ 폴더에 결과물 저장
```

### 3. GitHub Actions 자동 배포
```yaml
# .github/workflows/deploy.yml

트리거: main 브랜치에 push
  ↓
1. JDK 17 설치
  ↓
2. Gradle 캐시 복원
  ↓
3. kobwebExport 실행 (빌드)
  ↓
4. 빌드 결과물을 루트로 이동
  ↓
5. Vercel CLI로 배포
  ↓
완료! 🎉
```

### 4. 배포 흐름도
```
개발자가 코드 수정
    ↓
git push → GitHub
    ↓
GitHub Actions 자동 실행
    ↓
Kotlin/JS 빌드
    ↓
정적 파일 생성
    ↓
Vercel에 업로드
    ↓
https://itzme-eight.vercel.app 에서 확인!
```

---

## 🔥 트러블슈팅 히스토리

### 문제 1: 네비게이션이 안 돼요!
```
원인: 하나의 페이지에서 상태로만 관리
해결: Kobweb 라우팅 시스템 사용

Before:
- Index.kt 하나에 모든 섹션
- currentSection 상태로 전환

After:
- 각 섹션을 별도 페이지로 분리
- @Page 어노테이션 사용
- Link 컴포넌트로 네비게이션
```

### 문제 2: Vercel 배포 경로 에러
```
에러: site/.kobweb/site/site 경로 중복

원인: Vercel 프로젝트 설정 잘못됨

해결: 빌드 결과물을 루트로 이동
mv site/.kobweb/site/* .
```

### 문제 3: SPA 라우팅 안 됨
```
원인: 정적 사이트인데 SPA처럼 동작 기대

해결: vercel.json에 rewrite 규칙 추가
{
  "rewrites": [
    { "source": "/(.*)", "destination": "/index.html" }
  ]
}
```

---

## 💡 핵심 개념 정리

### Kobweb 핵심
1. **@Page** - 페이지 정의
2. **@Composable** - UI 컴포넌트
3. **Modifier** - 스타일링
4. **Link** - 네비게이션

### 파일 = URL 매핑
```
pages/Index.kt    → /
pages/About.kt    → /about
pages/Work.kt     → /work
pages/Contact.kt  → /contact
```

### 스타일링 3가지 방법
1. **Modifier 메서드**: `.background()`, `.padding()`
2. **styleModifier**: CSS 직접 적용
3. **Keyframes**: 애니메이션 정의

### 배포 자동화
```
코드 수정 → git push → GitHub Actions → Vercel 배포
            자동!        자동!          자동!
```

---

## 🎓 이제 뭘 할 수 있어?

### 새 페이지 추가하기
1. `pages/NewPage.kt` 파일 생성
2. `@Page("/new")` 어노테이션 추가
3. 컴포넌트 구현
4. 네비게이션에 추가

### 애니메이션 추가하기
1. `Keyframes` 정의
2. `.animation()` modifier 적용
3. 완료!

### 스타일 수정하기
1. 색상: `Color("#00ffff")` 수정
2. 폰트: `AppEntry.kt`에서 글로벌 스타일 수정
3. 레이아웃: `PageLayout.kt` 수정

---

## 🤔 자주 하는 질문

### Q: 왜 Kotlin으로 웹을?
A: Android 개발자가 익숙한 문법으로 웹 개발 가능!

### Q: React보다 나아?
A: 다르지! Kotlin 좋아하면 이게 편할 수 있어

### Q: 성능은 어때?
A: 정적 사이트 생성이라 빠름! 빌드 시간은 좀 걸림

### Q: 배포는 어떻게?
A: git push만 하면 자동! GitHub Actions + Vercel

---

## 📝 메모

- Kobweb은 아직 발전 중인 프레임워크
- 문서가 많지 않아서 삽질 가능성 있음
- 하지만 Kotlin 개발자에겐 꽤 매력적!
- Compose 문법 그대로 쓸 수 있는 게 장점

---
