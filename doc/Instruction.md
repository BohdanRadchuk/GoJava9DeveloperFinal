##Install instruction

Скачать исходники
Прописать доступ к базе данных в файле application.properties (в разделе "DATA SOURCE")
Прописать настройки mail сервера в файле application.properties (в разделе "MAIL")
Скомпилировать исходники
Запустить программу на выполнение. Доступ к REST серверу можно получить по ссылке http://localhost:8080/swagger-ui.html#!/

##User instructions

При первом запуске создаеться база данных кроме следующих данных: (эти данные нельзя удалить или изменить через преложение)

Roles: 
ROLE_ADMIN(johnSmith@gmail.com pass:john12345), 
ROLE_EMPLOYEE (sarahJones@gmail.com,sarah12345), 
ROLE_MODERATOR(oliviaEvans@gmail.com,olivia12345).

Некоторые особенности реализации и работы:

Изменить email или пароль к системе любой работник может только свой (не зависимо от того какая у него роль: ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR).

Если пользователь имеет роль ROLE_USER то он может видеть только ту информацию которая касается его и никого другого.
