CREATE TABLE TBL_FEEDBACK
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(50) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    category VARCHAR(20) NOT NULL,
    content  CLOB NOT NULL,
    filepath VARCHAR(250),
    progress BOOLEAN NOT NULL,
    date TIMESTAMP
);  