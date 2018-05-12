INSERT INTO company.employees (`email`, `password`, `first_name`, `last_name`, `address`, `phone`, `salary`)
VALUES ('first@mail.com', '123', 'First', 'Last', 'kyiv, hreshchatik 1', '0971234657', '55');

INSERT INTO company.roles (name) VALUES ('ADMIN'), ('MODERATOR'), ('WORKER');

INSERT INTO company.events (name) VALUES ('Working'), ('Studying');

INSERT INTO company.status (name) VALUES ('Working'), ('Sick leave'), ('Vacation');