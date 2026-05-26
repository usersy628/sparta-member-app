# sparta-member-app

## 필수과제

### LV 0 - 요금 폭탄 방지 AWS Budget 설정
AWS Budgets에서 월 예산을 $100 와 예산의 80% 도달 시 이메일 알림이 오도록 설정
![LV 0 - 요금 폭탄 방지 AWS Budget 설정.png](LV%200%20-%20%EC%9A%94%EA%B8%88%20%ED%8F%AD%ED%83%84%20%EB%B0%A9%EC%A7%80%20AWS%20Budget%20%EC%84%A4%EC%A0%95.png)

### LV 1 - 네트워크 구축 및 핵심 기능 배포
ec2 퍼블릭 ip - 3.38.163.245

### LV 2 - DB 분리 및 보안 연결하기
- Actuator Info 엔드포인트 URL : http://3.38.163.245:8080/actuator/info
- RDS 보안 그룹 스크린샷
![LV 2 - RDS 보안 그룹 스크린샷.png](LV%202%20-%20RDS%20%EB%B3%B4%EC%95%88%20%EA%B7%B8%EB%A3%B9%20%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7.png)

### LV 3 - 프로필 사진 기능 추가와 권한 관리

- 요청 URL: `POST http://EC2_PUBLIC_IP:8080/api/members/1/profile-image`
- 저장 위치: S3 private bucket
- DB 저장 값: `profile_image_key`

#### Presigned URL 검증

`Presigned URL`을 발급받아 브라우저에서 접속했을 때 이미지가 정상적으로 열리는 것을 확인
- Presigned URL: https://camp-health-kimsy628-files.s3.ap-northeast-2.amazonaws.com/uploads/fa28fb18-05ce-4b48-9615-33b546caa25c_LV%202%20-%20RDS%20%EB%B3%B4%EC%95%88%20%EA%B7%B8%EB%A3%B9%20%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEKb%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDmFwLW5vcnRoZWFzdC0yIkcwRQIhAMzIbarRrrNPkReAcVr9b88ezm4TIq73vVWsWfgNPWVMAiAcStUDZ53kHzXi8EXAUiGIlOoZIs7TSTMvydymVl6zzSrKBQhvEAAaDDQ0MzU2ODc4NTQ1MyIM0alsuk6%2B6U%2F6w5eHKqcFDFpE5O2iI%2B%2FAGxDRB1px%2B5c8zyvY1NS90Y0NI4%2FBWWqbzYm2XK4DFQGH1xdFG%2FneH%2FboLP%2FgJKp42CiY0yUDT7DbyvZENRMdJWZ57VrH%2FZTIhpwH%2Bh%2FdDZa7haHP7i8UrkLJ4nLlhjWE5MaM%2BhhTVRUxZAgNkUYj3NWwcCIWBPLzY1VfNu5E7aMXT1jA7POCvKcgzR%2BqrUNHzOt5vChL117GFnTnEBnqahgi04T02o6iba4YXsUq480%2Bp47guMVyh3pXihYB9oQp%2Fg93psnsl3DXFBqseVyaotry7sXpDmXM0sxgVXCnOzKFQdzj%2FG2ow8h%2B0%2BPv4QdOOBBGPFn5VGTGdTeST7vRNYgBQonlCceMY64H9jNO6dBh5dvNnVFFgXbTRLdWRyy84HlaDQujbOMquMBccOc%2FH5dZAUSVqTideD0lUg8i1%2B5WpgN2r0goqgtPLbxCETK0wl%2Fqj2O0CYybgNyoufZOUYFSx2b4oSzRDS3J3LF57VLKsg4njY6rRFKA9tuH%2BivR6Upzdocqu%2F%2B0W5M2TEgxlPliAHoni50BQMH5xABhHnGxLx%2FJBThrohpdjQyH%2BaiDNSOezxx2UXJOMphd1eaCzZAZXoNqAn%2Bz%2Fxq77QcfG6cn6fDsT4SwzVY9Lgg4%2BP8JVdscePFmxhiIk95VT1iUqQ49H5V5h2ujwrtWFkMvp9Nfw%2FtzeXS0cdfpN9pzkIO07PM%2BN3%2BHOzrfdL9int77Dqg6qAwUNlCph6HoLKtDaXtxfHL4%2BWDfApuNwdgBjb119SLAKh2zRcLJeqoM9TxvYPGl%2FB8TPs8QAuTpazaJ3Rhf5HIcEDhGkctw%2Fih9N8tC2RQuFo%2FnKsaH39at1ikKepUMKn6B3qS77ES0vnRZXWZKtwuG0uIyDcPOLDiwETDLkdPQBjqxAbaJYy585JNP%2Ba%2FZn52IoM7qe7COu11t9ilkDYMb45Gc%2FXhPbv1CfyRIwlXq%2FGkih5P36CN%2BN6IF3XQhRSxE7czw%2BSmguV6MIxs8MxZPPCziHnv9ihyNVOl8G0RBCO6Va2hKTJ5Jb9xnhLc%2F8JDjdmnQFJ3INbbnq1ALJ33Kk%2F4ThQRWJH4o%2BVfVCTD9A1a%2FGodcr1QPcsyIpDY%2BW2PDwMU6yPJBknoopnJA%2F3bcoS5lkg%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260525T223032Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIAWORWCRAW26DPI3ND%2F20260525%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=a4195b4059c4b690737fbd3aab404bebd7a02540f107f681f9d8711020b51c92
- X-Amz-Expires = 604800
- 만료 시간: 2026-06-02 07:30:32 KST


## 도전과제

### LV 4 - Docker & CI/CD 파이프라인 구축
1. Github Actions 성공 이미지
![LV 4 - Github Actions 성공 이미지.png](LV%204%20-%20Github%20Actions%20%EC%84%B1%EA%B3%B5%20%EC%9D%B4%EB%AF%B8%EC%A7%80.png)

2. EC2 터미널 이미지
![LV 4 - EC2 터미널 이미지(실행 중인 컨테이너 목록).png](LV%204%20-%20EC2%20%ED%84%B0%EB%AF%B8%EB%84%90%20%EC%9D%B4%EB%AF%B8%EC%A7%80%28%EC%8B%A4%ED%96%89%20%EC%A4%91%EC%9D%B8%20%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%20%EB%AA%A9%EB%A1%9D%29.png)

