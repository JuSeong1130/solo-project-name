INSERT INTO types(company_type, categories) VALUES (1, 'UX디자이너');
INSERT INTO types(company_type, categories) VALUES (2, 'UI디자이너');
INSERT INTO types(company_type, categories) VALUES (3, '기획');
INSERT INTO types(company_type, categories) VALUES (4, '운영');
INSERT INTO types(company_type, categories) VALUES (5, 'QA');
INSERT INTO types(company_type, categories) VALUES (6, '프론트엔드');
INSERT INTO types(company_type, categories) VALUES (7, '백엔드');
INSERT INTO types(company_type, categories) VALUES (8, '풀스택');
INSERT INTO types(company_type, categories) VALUES (9, 'Android');
INSERT INTO types(company_type, categories) VALUES (10, 'iOS');
INSERT INTO types(company_type, categories) VALUES (11, '데브옵스');
INSERT INTO types(company_type, categories) VALUES (12, '시스템엔지니어');
INSERT INTO types(company_type, categories) VALUES (13, '인프라엔지니어');
INSERT INTO types(company_type, categories) VALUES (14, '네트워크엔지니어');
INSERT INTO types(company_type, categories) VALUES (15, '데이터엔지니어');
INSERT INTO types(company_type, categories) VALUES (16, '데이터애널리스트');
INSERT INTO types(company_type, categories) VALUES (17, '데이터사이언티스트');
INSERT INTO types(company_type, categories) VALUES (18, '임베디드');
INSERT INTO types(company_type, categories) VALUES (19, '커널');

INSERT INTO locations(company_location, region) VALUES (1, '서울특별시');
INSERT INTO locations(company_location, region) VALUES (2, '부산광역시');
INSERT INTO locations(company_location, region) VALUES (3, '대구광역시');
INSERT INTO locations(company_location, region) VALUES (4, '인천광역시');
INSERT INTO locations(company_location, region) VALUES (5, '광주광역시');
INSERT INTO locations(company_location, region) VALUES (6, '대전광역시');
INSERT INTO locations(company_location, region) VALUES (7, '울산광역시');
INSERT INTO locations(company_location, region) VALUES (8, '세종특별자치시');
INSERT INTO locations(company_location, region) VALUES (9, '경기도');
INSERT INTO locations(company_location, region) VALUES (10, '강원도');
INSERT INTO locations(company_location, region) VALUES (11, '충청북도');
INSERT INTO locations(company_location, region) VALUES (12, '충청남도');
INSERT INTO locations(company_location, region) VALUES (13, '전라북도');
INSERT INTO locations(company_location, region) VALUES (14, '전라남도');
INSERT INTO locations(company_location, region) VALUES (15, '경상북도');
INSERT INTO locations(company_location, region) VALUES (16, '경상남도');
INSERT INTO locations(company_location, region) VALUES (17, '제주특별자치도');

INSERT INTO member(
    name, password, gender,
    company_name, company_type, company_location
)
VALUES
('idid', 'pwpw', 'MALE', 'ICBC', 7, 1),
('iddid_1', 'pwd1', 'MALE','중국건설은행', 1, 1),
('iddid_2', 'pwd2', 'FEMALE', 'JP모건 체이스', 2, 2),
('iddid_3', 'pwd3', 'FEMALE', '버크셔 해서웨이', 1, 3),
('iddid_4', 'pwd4', 'FEMALE', '중국농업은행', 3, 3),
('iddid_5', 'pwd5', 'MALE', '사우디 아람코', 2, 2)
