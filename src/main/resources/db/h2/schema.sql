CREATE TABLE `Types` (
	`company_type`	Number PRIMARY KEY AUTO_INCREMENT,
	`categories`	VARCHAR(255)	NULL
);

CREATE TABLE `Locations` (
	`company_location`	Number PRIMARY KEY AUTO_INCREMENT,
	`region`	VARCHAR(255)	NULL
);

CREATE TABLE `member` (
	`id`	Number PRIMARY KEY AUTO_INCREMENT,
	`company_location`	Number	NOT NULL,
	`company_type`	Number	NOT NULL,
	`name`	VARCHAR(255)	NULL,
	`password`	VARCHAR(255)	NULL,
	`gender`	VARCHAR(255)	NULL,
	`company_name`	VARCHAR(255)	NULL
);
/*ALTER TABLE member ADD PRIMARY KEY(id);

ALTER TABLE Types ADD PRIMARY KEY(company_type);

ALTER TABLE Locations ADD PRIMARY KEY(company_location);*/

ALTER TABLE Member ADD FOREIGN KEY (company_location) REFERENCES Locations (company_location);

ALTER TABLE Member ADD FOREIGN KEY (company_type) REFERENCES Types (company_type);


