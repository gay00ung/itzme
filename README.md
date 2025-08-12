# 🌟 ITZME - gay00ung 포트폴리오

> Kotlin/JS + Kobweb + Jetpack Compose로 구현된 현대적인 웹 포트폴리오

[![Build and Deploy](https://github.com/gay00ung/itzme/actions/workflows/deploy.yml/badge.svg)](https://github.com/gay00ung/itzme/actions/workflows/deploy.yml)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.0-blue.svg)](https://kotlinlang.org)
[![Kobweb](https://img.shields.io/badge/Kobweb-0.23.0-purple.svg)](https://github.com/varabyte/kobweb)
[![Vercel](https://img.shields.io/badge/Deployed%20on-Vercel-black.svg)](https://vercel.com)

## 📖 프로젝트 개요

**ITZME**는 사이버펑크 컨셉의 독창적인 개인 포트폴리오 웹사이트입니다. 안드로이드 개발자로서의 정체성을 강하게 드러내는 터미널 스타일 UI와 네온 효과, 글리치 애니메이션을 통해 차별화된 사용자 경험을 제공합니다.

### ✨ 주요 특징

- 🎨 **사이버펑크 디자인**: 네온 컬러, 글리치 효과, 터미널 UI
- 💻 **개발자 중심**: 실제 코드 블록, 모노스페이스 폰트
- ⚡ **현대적 기술**: Kotlin/JS, Compose, Kobweb
- 📱 **반응형 디자인**: 모든 디바이스 지원
- 🚀 **자동 배포**: GitHub Actions + Vercel CI/CD

### 🎯 타겟 사용자

- 안드로이드 개발 포지션 지원 시 포트폴리오
- 개발자 커뮤니티 네트워킹
- 클라이언트 프로젝트 문의

## 🛠️ 기술 스택

### 핵심 프레임워크
```kotlin
Kotlin 2.2.0                 // 최신 Kotlin 버전
Kobweb 0.23.0               // 웹 프레임워크
Jetpack Compose 1.8.0      // 선언적 UI
```

### 주요 라이브러리
```kotlin
// UI 및 스타일링
compose-runtime             // Compose 런타임
compose-html-core          // HTML 코어
kobweb-silk               // Silk UI 컴포넌트
silk-icons-fa            // Font Awesome 아이콘

// 추가 기능
kobwebx-markdown         // 마크다운 지원
```

### 개발 도구
```bash
Gradle 8.x              # 빌드 시스템
IntelliJ IDEA          # 권장 IDE
Git                    # 버전 관리
```

### 배포 및 호스팅
```yaml
GitHub Actions         # CI/CD 파이프라인
Vercel                # 정적 사이트 호스팅
```

## 🎨 디자인 시스템

### 컬러 팔레트
```css
Primary:    #00ffff    /* 사이버 블루 */
Background: #000000    /* 순수 검정 */
Secondary:  #666666    /* 중간 그레이 */
Accent:     #ffffff    /* 순수 흰색 */
Gradient:   #00ffff → #ff00ff  /* 네온 그라데이션 */
```

### 타이포그래피
```css
/* 메인 폰트 (개발자 느낌) */
font-family: 'JetBrains Mono', 'Courier New', monospace;

/* 한글 폰트 (9가지 웨이트) */
font-family: 'Pretendard', 'Apple SD Gothic Neo', sans-serif;
```

### 애니메이션
- **Glitch Animation**: 텍스트 글리치 효과 (3초 주기)
- **Scan Line**: 스캔라인 이동 (8초 주기)
- **Cursor Blink**: 타이핑 커서 깜박임 (1초 주기)
- **Move Horizontal**: 점 수평 이동 (2초 주기)

## 📱 페이지 구성

### 네비게이션
```
Single Page Application (SPA)
├── HOME     # 메인 섹션
├── ABOUT    # 자기소개 및 기술 스택
├── WORK     # 프로젝트 포트폴리오
└── CONTACT  # 연락처 정보
```

### 섹션별 상세 내용

#### 🏠 HOME Section
- **좌측**: "ANDROID DEVELOPER" 대형 타이틀
- **우측**: 실제 MainActivity.kt 코드 블록
- **특징**: 터미널 창 UI, 구문 강조, 애니메이션

#### 👨‍💻 ABOUT Section
```
통계 정보:
- EXPERIENCE: 2+ YEARS
- PROJECTS: 5+ APPS  
- TECH STACK: 5+ TOOLS

기술 스택:
KOTLIN | COMPOSE | ANDROID | GIT | CLEAN ARCH | COROUTINES
```

#### 💼 WORK Section
5개 주요 프로젝트:
```
01. POIT         - AI 기반 음식 영양정보 (GPT API/Firebase)
02. 환율톡톡      - 환율 알리미 (KMP/Koin/Clean Architecture)
03. 모노로그      - 감정 일기장 (Compose/Ktor/Firebase)
04. WorgleWorgle - 단어 맞추기 게임 (Kotlin/Compose)
05. QR MINE      - QR 생성 앱 (Kotlin/ZXING)
```

#### 📞 CONTACT Section
```
Email:    gayoung990911@gmail.com
GitHub:   github.com/gay00ung
LinkedIn: linkedin.com/in/가영-신-5118552b2
```

## 🚀 시작하기

### 필수 요구사항

```bash
# 필수 소프트웨어
JDK 17+                 # Java Development Kit
Node.js 16+            # JavaScript 런타임
Git                    # 버전 관리

# 권장 IDE
IntelliJ IDEA Community Edition
```

### 프로젝트 클론

```bash
# 저장소 클론
git clone https://github.com/gay00ung/itzme.git
cd itzme

# 의존성 확인
./gradlew --version
```

### 로컬 개발 서버 실행

```bash
# 개발 서버 시작
cd site
kobweb run

# 또는 Gradle 태스크 사용
./gradlew :site:kobwebStart
```

브라우저에서 [http://localhost:8080](http://localhost:8080) 접속

### 개발 모드 특징

- 🔄 **Live Reload**: 코드 변경 시 자동 새로고침
- 🔍 **Hot Module Replacement**: 빠른 개발 피드백
- 📊 **개발자 도구**: 브라우저 디버깅 지원
- 💾 **자동 저장**: 파일 변경 감지

### 개발 서버 중지

```bash
# 터미널에서 Q 키 입력
Q
```

## 📦 빌드 및 배포

### 프로덕션 빌드

```bash
# 정적 사이트 생성
./gradlew :site:kobwebExport

# 빌드 결과 확인
ls site/.kobweb/site/
```

### 로컬 프로덕션 서버

```bash
# 프로덕션 모드 실행
kobweb run --env prod

# 비대화형 모드 (서버용)
kobweb run --env prod --notty
```

### 자동 배포 (GitHub Actions)

#### 배포 트리거
- ✅ `main` 브랜치 푸시 → 프로덕션 배포
- ✅ Pull Request → 프리뷰 배포

#### 배포 프로세스
```yaml
1. JDK 17 설정
2. Gradle 캐시 복원
3. Kobweb 빌드 실행
4. Vercel 배포
   - Production: main 브랜치
   - Preview: PR 브랜치
```

#### 필수 GitHub Secrets
```bash
VERCEL_TOKEN        # Vercel API 토큰
VERCEL_ORG_ID      # Vercel 조직 ID
VERCEL_PROJECT_ID  # Vercel 프로젝트 ID
```

### Vercel 설정

#### 프로젝트 설정
```json
{
  "framework": "Other",
  "buildCommand": "",
  "outputDirectory": "",
  "installCommand": "",
  "ignoredBuildStep": "exit 1"
}
```

#### 환경 변수
```bash
# 필요 시 추가 환경 변수 설정
ENVIRONMENT=production
```

## 🗂️ 프로젝트 구조

```
itzme/
├── .github/workflows/          # CI/CD 설정
│   └── deploy.yml             # GitHub Actions 워크플로우
├── site/                      # 메인 웹사이트
│   ├── src/jsMain/kotlin/     # Kotlin 소스 코드
│   │   └── net/ifmain/itzme/
│   │       ├── AppEntry.kt    # 앱 진입점
│   │       ├── pages/
│   │       │   └── Index.kt   # 메인 페이지 (887줄)
│   │       └── components/
│   │           ├── AnimatedBackground.kt
│   │           ├── ModernStyles.kt
│   │           └── ProfileStyles.kt
│   ├── src/jsMain/resources/  # 리소스 파일
│   │   └── public/
│   │       ├── fonts/         # Pretendard 폰트 (9가지)
│   │       ├── fonts.css      # 폰트 정의
│   │       └── favicon.ico
│   └── build.gradle.kts       # 사이트 빌드 설정
├── gradle/                    # Gradle 래퍼
├── build.gradle.kts          # 루트 빌드 설정
├── settings.gradle.kts       # 프로젝트 설정
├── gradle.properties         # Gradle 환경설정
├── vercel.json              # Vercel 배포 설정
└── README.md                # 프로젝트 문서 (이 파일)
```

### 핵심 파일 설명

#### `site/src/jsMain/kotlin/net/ifmain/itzme/`
- **AppEntry.kt** (30줄): 앱 초기화, 글로벌 스타일 설정
- **pages/Index.kt** (887줄): 메인 페이지, 4개 섹션 구현
- **components/**: 재사용 가능한 UI 컴포넌트들

#### 빌드 설정
- **build.gradle.kts**: Kobweb 앱 설정, 의존성 관리
- **settings.gradle.kts**: 멀티모듈 프로젝트 구성
- **gradle.properties**: 성능 최적화 설정

## ⚙️ 개발 가이드

### 코드 스타일

#### Kotlin 컨벤션
```kotlin
// 1. 컴포넌트 네이밍: PascalCase
@Composable
fun HeroSection() { /* ... */ }

// 2. 변수 네이밍: camelCase
var currentSection by remember { mutableStateOf(0) }

// 3. 상수: UPPER_SNAKE_CASE
val PRIMARY_COLOR = "#00ffff"
```

#### 스타일링 패턴
```kotlin
// 1. Modifier 체이닝
Modifier
    .fillMaxSize()
    .background(Color("#000000"))
    .styleModifier {
        property("font-family", "'JetBrains Mono', monospace")
    }

// 2. 키프레임 애니메이션
val GlitchAnimation = Keyframes {
    from { /* 시작 상태 */ }
    20.percent { /* 중간 상태 */ }
    to { /* 끝 상태 */ }
}
```

### 새로운 섹션 추가

#### 1. 네비게이션 업데이트
```kotlin
// pages/Index.kt의 topNavBar 함수
val sections = listOf("HOME", "ABOUT", "WORK", "CONTACT", "NEW_SECTION")
```

#### 2. 섹션 컴포넌트 생성
```kotlin
@Composable
fun newSection() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(100.px)
    ) {
        // 섹션 내용 구현
    }
}
```

#### 3. 라우팅 추가
```kotlin
// homePage 함수의 when 구문
when(currentSection) {
    0 -> heroSection()
    1 -> aboutSection()
    2 -> workSection()
    3 -> contactSection()
    4 -> newSection()  // 새 섹션 추가
}
```

### 애니메이션 추가

```kotlin
// 1. 키프레임 정의
val CustomAnimation = Keyframes {
    from { 
        Modifier.transform { translateX(0.px) }
    }
    to { 
        Modifier.transform { translateX(100.px) }
    }
}

// 2. 컴포넌트에 적용
Box(
    Modifier.animation(CustomAnimation.toAnimation(2.s))
)
```

### 스타일 커스터마이징

#### 컬러 테마 변경
```kotlin
// AppEntry.kt에서 글로벌 스타일 수정
ctx.stylesheet.registerStyleBase("html, body") { 
    Modifier
        .background(Color("#YOUR_NEW_COLOR"))  // 배경색 변경
}
```

#### 폰트 변경
```css
/* fonts.css에서 폰트 추가 */
@font-face {
    font-family: 'YourFont';
    src: url('/fonts/YourFont.woff') format('woff');
}
```

### 성능 최적화

#### 빌드 최적화
```kotlin
// build.gradle.kts에서 프로덕션 설정
kobweb {
    app {
        export {
            includeSourceMap = false  // 소스맵 제거
        }
    }
}
```

#### 이미지 최적화
```bash
# WebP 형식 사용 권장
cwebp input.jpg -o output.webp -q 80
```

## 📈 확장 가능성

### 추가 기능 아이디어

#### 1. 다국어 지원
```kotlin
// i18n 라이브러리 추가
implementation("com.varabyte.kobwebx:kobwebx-markdown")
```

#### 2. 다크/라이트 모드
```kotlin
// 테마 상태 관리
var isDarkMode by remember { mutableStateOf(true) }
```

#### 3. 블로그 섹션
```markdown
# 마크다운 파일 지원
site/src/jsMain/resources/markdown/
├── blog-post-1.md
└── blog-post-2.md
```

#### 4. 성능 모니터링
```javascript
// Google Analytics 통합
gtag('config', 'GA_MEASUREMENT_ID')
```

## 🤝 기여 가이드

### Pull Request 프로세스

1. **Fork** 저장소
2. **Feature 브랜치** 생성
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **변경사항 커밋**
   ```bash
   git commit -m "feat: Add amazing feature"
   ```
4. **브랜치 푸시**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Pull Request** 생성

### 커밋 메시지 컨벤션

```bash
feat: 새로운 기능 추가
fix: 버그 수정  
docs: 문서 업데이트
style: 코드 포맷팅
refactor: 코드 리팩터링
test: 테스트 추가
chore: 빌드/설정 변경
```

## 📞 연락처

- **개발자**: 가영 (Gayoung)
- **이메일**: gayoung990911@gmail.com
- **GitHub**: [@gay00ung](https://github.com/gay00ung)
- **LinkedIn**: [linkedin.com/in/gayoung](https://www.linkedin.com/in/%EA%B0%80%EC%98%81-%EC%8B%A0-5118552b2/)

---

**💻 Happy Coding! 🚀**