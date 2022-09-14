CREATE TABLE author
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    login       VARCHAR(255),
    first_name  VARCHAR(255),
    middle_name VARCHAR(255),
    last_name   VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE news
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    author_id        BIGINT                NOT NULL,
    title            VARCHAR(255)          NOT NULL,
    content          VARCHAR(255)          NOT NULL,
    image_uri        VARCHAR(255),
    status           VARCHAR(255)          NOT NULL,
    publication_date TIMESTAMP with time zone,
    CONSTRAINT pk_news PRIMARY KEY (id)
);

ALTER TABLE news
    ADD CONSTRAINT FK_NEWS_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);