-- INSERT INTO TBL_FEEDBACK (email, priority, category, content) VALUES
--   ('abc@gmdsaail.com', 'te4sdast', 'tes3dsat', 'testdsa2');
--




CREATE TABLE TBL_FEEDBACK(
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
priority VARCHAR(250) NOT NULL,
category VARCHAR(250) NOT NULL,
content VARCHAR(250) NOT NULL,
progress VARCHAR(250) NOT NULL
);  