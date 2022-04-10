КубаньКредит Банк test task.
--

Написать простое REST Приложение, реализующее функционал трекера задач (реализаиция фронта - по желанию, достаточно взаимодействия через http клиент - postman, jars, soapUI и т.д.)

1. endpoint возвращает список существующих задач
2. endpoint возвращает задачу по номеру, если её не существует возвращает соответствующую ошибку
3. endpoint на основе полученных данных - заголовок задачи и краткое описание создает задачу в любой реляционной БД (по желанию возможно использоватья не реляционные)
4. endpoint редактирование задачи
5. endpoint удаление задачи

Написать инструкцию по запуску приложения. Выложить проект в github, прислать ссылку на проект. Выбор используемых технологий, не требуемых в условиях задачи - на ваше усмотрение.

---
Grigorev Michail solution
--
В программе применяется SQLLite - поэтому не требуется прописывать настройки базы данных.

В программе отсутствует фронтенд, поэтому тестировать возможно с помощью http клиента, например Postman

1. Список существующих задач - get запрос его возможно выполнить в браузере командой http://localhost:8080/tasks, либо get запросом в Postman.
   Предварительно конечно стоит добавить задач в БД см. п.3
2. Получение задачи по номеру - get запрос его возможно выполнить в браузере командой http://localhost:8080/task0/x, (вместо x - номер задачи) либо get запросом в Postman.
   Предварительно конечно стоит добавить задач в БД см. п.3
   При отсутствии номера задачи в БД ответ будет 404 - Not Found.
3. Создание задачи - post запрос 
в postman запрос http://localhost:8080/tasks, 
Body - raw, JSON. 
   {
   "header":"заголовок новой задачи",
   "shortDescription":"короткое описание",
   "description":"описание"
   }
Все пункты обязательны, т.е. не могут быть null.
4. Редактирование задачи - put запрос
      в postman запрос http://localhost:8080/tasks/x, (вместо x - номер задачи)
      Body - raw, JSON.
      {
      "id": x, (вместо x - номер задачи)
      "header":"заголовок новой задачи",
      "shortDescription":"короткое описание",
      "description":"описание"
      }
      Все пункты обязательны, т.е. не могут быть null.
5. Удаление задачи - delete запрос
в postman запрос http://localhost:8080/tasks/x, (вместо x - номер задачи)

