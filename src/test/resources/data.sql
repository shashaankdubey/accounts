DROP TABLE IF EXISTS user_accounts;

CREATE TABLE user_accounts (
  id INT NOT NULL,
  name VARCHAR(150) NOT NULL,
  phone VARCHAR(12) NOT NULL,
  email VARCHAR(200) NOT NULL,
  address VARCHAR(200),
  country VARCHAR(56) NOT NULL,
  department VARCHAR(50) NOT NULL
);
