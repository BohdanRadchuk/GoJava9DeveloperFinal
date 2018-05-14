CREATE SCHEMA IF NOT EXISTS spring
  DEFAULT CHARACTER SET utf8;

CREATE SCHEMA IF NOT EXISTS company
DEFAULT CHARACTER SET utf8;
USE company;

CREATE TABLE IF NOT EXISTS company.employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(120)NOT NULL,
  address VARCHAR(250) NOT NULL,
  phone VARCHAR(50) NOT NULL,
  salary DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS company.roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS company.employees_roles (
  id_employee INT NOT NULL,
  id_role INT NOT NULL,
  FOREIGN KEY (id_employee) REFERENCES company.employees (id) ON DELETE CASCADE,
  FOREIGN KEY (id_role) REFERENCES company.roles(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS company.posts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS company.employees_posts (
  id_employee INT NOT NULL,
  id_post INT NOT NULL,
  FOREIGN KEY (id_employee) REFERENCES company.employees (id) ON DELETE CASCADE,
  FOREIGN KEY (id_post) REFERENCES company.posts(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS company.departments (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS company.employees_departments (
  id_employee INT NOT NULL,
  id_department INT NOT NULL,
  FOREIGN KEY (id_employee) REFERENCES company.employees (id) ON DELETE CASCADE,
  FOREIGN KEY (id_department) REFERENCES company.departments(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS company.events (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS company.employees_events (
  id_employee INT NOT NULL,
  id_event INT NOT NULL,
  start_date DATE NOT NULL,
  amount_of_hours INT NOT NULL,
  FOREIGN KEY (id_employee) REFERENCES company.employees (id) ON DELETE CASCADE,
  FOREIGN KEY (id_event) REFERENCES company.departments(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS company.status (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS company.employees_status (
  id_employee INT NOT NULL,
  id_status INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  FOREIGN KEY (id_employee) REFERENCES company.employees (id) ON DELETE CASCADE,
  FOREIGN KEY (id_status) REFERENCES company.departments(id) ON DELETE CASCADE
);
