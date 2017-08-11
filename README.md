ansible-km-iris-logstash
=======================

[![logstash](https://img.shields.io/badge/Logstash-5.5.0-brightgreen.svg)](https://www.elastic.co/guide/en/logstash/current/introduction.html)
[![ansible](https://img.shields.io/badge/ansible-2.3-orange.svg)](https://www.ansible.com/it-automation)

## Index
1. <a href="#1-directories-schema">Directories schema</a>
2. <a href="#2-logstash-설치-및-설정시에-사전-확인해야-할-항목--실행-계정">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 실행 계정</a>
3. <a href="#3-logstash-설치-및-설정시에-사전-확인해야-할-항목--파일-및-다운로드-url-정보">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 파일 및 다운로드 URL 정보</a>
4. <a href="#4-logstash-설치-및-설정시에-사전-확인해야-할-항목--inputoutput-config-관련-항목">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > input/output config 관련 항목</a>
5. <a href="#5-logstash-설치-및-설정시에-사전-확인해야-할-항목--logstash-설치-및-설정-대상-서버-목록">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > Logstash 설치 및 설정 대상 서버 목록</a>
6. <a href="#6-logstash-설치-및-설정시에-사전-확인해야-할-항목--jdk-설치-및-설정">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > JDK 설치 및 설정</a>
7. <a href="#7-logstash-설치-및-설정시에-사전-확인해야-할-항목--기타-항목-및-플러그인-설정-항목">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 기타 항목 및 플러그인 설정 항목</a>
8. <a href="#8-logstash-설치-및-설정시에-사전-확인해야-할-항목--모피어스-알림smith">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 모피어스 알림(Smith)</a>
9. <a href="#9-logstash-설치-및-설정시에-사전-확인해야-할-항목--logstash-플러그인-설정-항목들-확인">Logstash 설치 및 설정시에 사전 확인해야 할 항목 > Logstash 플러그인 설정 항목들 확인</a>
10. <a href="#10-전체-설치-디렉터리-생성-jdk-설치-logstash설치-등">전체 설치 (디렉터리 생성, JDK 설치, Logstash설치 등)</a>
11. <a href="#11-logstash만-설치">Logstash만 설치</a>
12. <a href="#12-logstash만-시작--중지--재시작">Logstash만 시작 / 중지 / 재시작</a>


### 사전작업
신규서버의 ~/.ssh/authorized_keys에 deploy 계정의 public key를 추가

```
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDED6D6MgeYMx5eg8JSZjPp6nVMIMygdnL7pV0WV/coGHwyro8kPLDhIYryhSjVNA8ShknwZoXAGJ+lFcHuOB8dpcAlRpnMCdZW2ROvdNIjT6n6TnLDn5ZP6wJCmih8O862r4NPJBH5YJWMAW2vHV0SdVur0rrEw8UDwrDsQe41zKjDxXTAuMiAeY14gjdYtj7/lqE6ZnWYhr8N9EXopM5REYzxS/C/Aa6pne7a1bo3nmkF+d+kzAYYEAN1MeSGtmPlJ98LIOt41l1M+Tyg8WCkE6pe1VFgzrdeWQ7xZeYwdPxECiezyPI+hP8AoFRsc++OGFBkCPqN1SAzTkFMddxSqEfJtz8yFEG1/LMWwIsy2yTvYpZHxFdzbPiFhnmR0yo5XK0YVUZBkThnI2jlGcFRRN7BxLnFLGdsC18qsPWB8xIyzCAsxkik8AdLYad2YIQtsLbQJb2QrVVDPRes4BoXCzwqL7dnmmITFc12VTWZMLz1Rg98yY3heTqVMzdNwk4zLye5BEgqJj0HZGfLiVC4Gp1AvNYmXmBwUNc/QYWl3gOW7rdgWIJNAMDWeseBtTuv7ENaFS54ECQgsoz5QrE01iEvNPSR67p8wvd08gume0oLBGoDkKKhArMbZbJrqiy3b9i6RAT5uafkJKh2Zi2tBwI8/PpAkeVkOKKpa+wZHw== deploy@km-billing-deploy01.pg1.krane.9rum.cc
```

### 1. Directories schema

Directory | desc  |
| ------------- | ------------- |
| group_vars | `Logstash`를 install하기 위한 전역 설정 값들이 정의되어 있습니다. |
| inventories  | 설치할 서버 정보가 정의되어 있습니다.  |
| roles  | 디렉터리 생성, JDK 설정 등과 같은 기본 설정과 `Logstash` 설치까지의 모든 과정이 태스크로 정의되어 있습니다. |`  
        
### 2. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 실행 계정
`디렉터리 : group_vars`  
`파일이름 : all`

items | desc  | 필수 확인
| ------------- | ------------- |---|
| account.user | 실행 계정의 아이디  |Y
| account.group  | 실행 계정의 그룹  |Y

### 3. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 파일 및 다운로드 URL 정보
```이미 설치된 Elasticsearch가 클러스터 구조일 경우 기존에 설치된 Logstash의 버전과 맞춰줘야 한다.```  
`디렉터리 : group_vars`  
`파일이름 : all`

items | desc  | 필수 확인
| ------------- | ------------- |---|
| logstash.version | 설치하고자 하는 Logstash 버전  |Y
| logstash.filename | 설치하고자 하는 Logstash 파일명 (확장자 제외)  |Y
| logstash.url | 설치하고자 하는 버전의 Logstash 다운로드 URL  |Y

### 4. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > input/output config 관련 항목
`디렉터리 : group_vars`  
`파일이름 : all` 

items | desc  | 필수 확인
| ------------- | ------------- |---|
| logstash.conf.input.bootstrap_servers|Kafka Address |Y
| logstash.conf.input.codec|Kafka 메시징 코덱|Y
| logstash.conf.input.group_id|Consumer가 속한 그룹의 식별자|Y
| logstash.conf.input.client_id|ID 문자열|Y or N (되도록 체크)
| logstash.conf.output.hosts|Elasticsearch의 마스터 노드 address 혹은 도메인|Y

### 5. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > Logstash 설치 및 설정 대상 서버 목록
`디렉터리 : inventories/하위`  
`파일이름 : main.yml`  

`신규 서버 추가시에는 **[logstash-develop-new]** 혹은 **[logstash-production-new]** 추가후 Logstash 설치 및 설정 진행`  
`모든 설정 완료 후에는 기존 **[logstash-develop]** 및 **[logstash-production]** 에 해당 서버 호스트 추가하고 *-new 호스트 그룹은 삭제`

### 6. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > JDK 설치 및 설정
```JDK가 이미 설된 경우 고려하지 않아도 된다.```  
`디렉터리 : roles/jdk/vars`  
`파일이름 : main.yml`  

items | desc  | 필수 확인
| ------------- | ------------- |---|
| jdk.version | 설치하고자하는 JDK 버전  |N
| jdk.file | JDK 파일 (확장자 포함)  |N
| jdk.url | JDK 파일 다운로드 URL  |N


### 7. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 기타 항목 및 플러그인 설정 항목
`디렉터리 : roles/logstash/vars`  
`파일이름 : main.yml`

items | desc  | 필수 확인 항목
| ------------- | ------------- |---|
| config.logstash.plugin.xpack | logstash.yml (환경설정 파일)에 x-pack 관련 항목을 설정할 것인지 여부  |Y
| config.logstash.file | 로깅 관련한 input/filter/output 파일명  |Y
| config.logstash.reload.automatic | config.logstash.file 을 자동으로 reload 할 것인지 여부  |Y
| config.logstash.reload.interval | config.logstash.file 을 자동으로 reload 할 경우 interval  |Y
| config.logstash.jvm.xms | JVM의 -Xms 설정값  |Y
| config.logstash.jvm.xmx | JVM의 -Xmx 설정값   |Y
| config.plugin.xpack.security.enabled | x-pack 플러그인의 보안 보안 설정을 사용할 것인지 여부  |Y
| config.plugin.xpack.monitoring.enabled | x-pack 플러그인의 모니터링 기능을 사용할 것인지 여부  |Y
| config.input.list[].type | Kafka 메시지 type 이름  |Y
| config.input.list[].bootstrap_servers | Kafka Address  |Y
| config.input.list[].topics | Kafka 토픽이름   |Y
| config.input.list[].group_id | Kafka 토픽이름   |Y
| config.input.list[].codec | input 메시지 코덱    |Y
| config.output.list[].type | Kafka 메시지 type 이름   |Y
| config.output.list[].index | Elasticsearch에 생성될 인덱스 이름   |Y
| config.output.list[].hosts | group_vars.all.logstash.conf.output.hosts   |Y
| config.output.list[].document_id | 클러스터링 구조일 경우 document가 중복으로 저장되지 않게끔 유니크키를 지정    |Y
| config.output.list[].codec | output 메시지 코덱  |Y

### 8. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > 모피어스 알림(Smith)
`디렉터리 : roles/morpheus/vars`  
`파일이름 : main.yml`

items | desc  | 필수 확인 항목
| ------------- | ------------- |---|
| smith.url | 모피어스 알림 에이전트인 Smith 다운로드 URL  |N


###  9. Logstash 설치 및 설정시에 사전 확인해야 할 항목 > Logstash 플러그인 설정 항목들 확인 
`디렉터리 : roles/plugin/vars`
`파일이름 : main.yml`

items | desc  | 필수 확인 항목
| ------------- | ------------- |---|
| plugin.xpack.version | X-pack 플러그인 버전  |Y
| plugin.xpack.file | X-pack 플러그인 파일 (확장자 포함)  |Y
| plugin.xpack.url | X-pack 플러그인 다운로드 URL  |Y

### 10. 전체 설치 (디렉터리 생성, JDK 설치, Logstash설치 등)
Develop - syntax  
```sh
ansible-playbook -i inventories/대상서버군(develop) launcher.yml --extra-vars "host=서버 호스트"
```
Develop - sample
```sh
ansible-playbook -i inventories/logstash-develop launcher.yml --extra-vars "host=logstash-develop"
```
 
Production - syntax
```sh
ansible-playbook -i inventories/대상서버군(production) launcher.yml --extra-vars "host=서버 호스트"
```
Develop - sample
```sh
ansible-playbook -i inventories/logstash-production launcher.yml --extra-vars "host=logstash-production"
```

### 11. Logstash만 설치
Logstsh - syntax
```sh
ansible-playbook -i inventories/대상서버군 logstash_setup.yml --extra-vars "host=서버 호스트"
```

### 12. Logstash만 시작 / 중지 / 재시작
Logstash - 시작
```sh
ansible-playbook -i inventories/대상서버군 logstash_start.yml --extra-vars "host=서버 호스트"
```
Logstash - 중지
```sh
ansible-playbook -i inventories/대상서버군 logstash_stop.yml --extra-vars "host=서버 호스트"
```
Logstash - 재시작
```sh
ansible-playbook -i inventories/대상서버군 logstash_restart.yml --extra-vars "host=서버 호스트"
```
