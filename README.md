# TeacherCloud 🌥️

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-C71A36?style=for-the-badge&logo=Angular&logoColor=white)

## Descripción de la Aplicación 📚

TeacherCloud es una aplicación diseñada para gestionar la relación entre profesores y estudiantes, facilitando la administración de cursos, tareas, eventos y foros de discusión. La plataforma permite a los profesores organizar sus clases y a los estudiantes mantenerse al día con sus responsabilidades académicas.

### Características Principales ✨

- **Gestión de Usuarios**: Permite registrar y gestionar perfiles de profesores y estudiantes.
- **Administración de Cursos**: Los profesores pueden crear y gestionar cursos y asignaturas.
- **Asignación de Tareas**: Los profesores pueden asignar tareas y los estudiantes pueden entregarlas.
- **Eventos y Recordatorios**: Gestión de eventos importantes relacionados con los cursos.
- **Foros de Discusión**: Espacios para que los estudiantes y profesores discutan temas relevantes.
- **Mensajería**: Comunicación directa entre usuarios.
- **Calificaciones**: Asignación y seguimiento de calificaciones de tareas.

## Entidades y Relaciones 📊

- **Entidad**: Entidad, clase base de la heredaran todas. proporciona el ID y logs de control.

- **Usuario**: Representa a los usuarios de la aplicación, que pueden ser profesores o estudiantes.
- **Curso**: Los cursos que se imparten en la plataforma.
- **Asignatura**: Las asignaturas que forman parte de un curso.
- **Tarea**: Las tareas asignadas a los estudiantes.
- **Evento**: Eventos relacionados con las asignaturas o tareas.
- **Foro**: Foros de discusión para cada asignatura.
- **Tema**: Temas de discusión dentro de un foro.
- **Comentario**: Comentarios dentro de un tema de foro.
- **Mensaje**: Mensajes enviados entre usuarios.
- **Calificación**: Calificaciones asignadas a las tareas.

### Relaciones 🔗

- Un **Usuario** puede estar inscrito en muchos **Cursos** (N a N).
- Un **Usuario** puede enviar muchos **Mensajes** (1 a N).
- Un **Curso** puede tener muchas **Asignaturas** (1 a N).
- Una **Asignatura** puede tener muchas **Tareas** (1 a N).
- Una **Asignatura** puede tener muchos **Eventos** (1 a N).
- Una **Asignatura** puede tener muchos **Foros** (1 a N).
- Una **Tarea** puede estar asociada a un **Evento** (1 a 1).
- Una **Tarea** puede tener una **Calificación** (1 a 1).
- Un **Foro** puede tener muchos **Temas** (1 a N).
- Un **Tema** puede tener muchos **Comentarios** (1 a N).

## Estructura del Proyecto 📁

```
TeacherCloud/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── teachercloud/
│   │   │           ├── config/
│   │   │           │   └── SecurityConfig.java
│   │   │           ├── controller/
│   │   │           │   ├── CourseController.java
│   │   │           │   ├── EventController.java
│   │   │           │   ├── ForumController.java
│   │   │           │   ├── TaskController.java
│   │   │           │   └── UserController.java
│   │   │           ├── model/
│   │   │           │   ├── Entidad.java
│   │   │           │   ├── Course.java
│   │   │           │   ├── Event.java
│   │   │           │   ├── Forum.java
│   │   │           │   ├── Grade.java
│   │   │           │   ├── Message.java
│   │   │           │   ├── Subject.java
│   │   │           │   ├── Task.java
│   │   │           │   ├── Topic.java
│   │   │           │   ├── User.java
│   │   │           │   └── Comment.java
│   │   │           ├── repository/
│   │   │           │   ├── CourseRepository.java
│   │   │           │   ├── EventRepository.java
│   │   │           │   ├── ForumRepository.java
│   │   │           │   ├── GradeRepository.java
│   │   │           │   ├── MessageRepository.java
│   │   │           │   ├── SubjectRepository.java
│   │   │           │   ├── TaskRepository.java
│   │   │           │   ├── TopicRepository.java
│   │   │           │   └── UserRepository.java
│   │   │           ├── service/
│   │   │           │   ├── EntidadService.java
│   │   │           │   ├── CourseService.java
│   │   │           │   ├── EventService.java
│   │   │           │   ├── ForumService.java
│   │   │           │   ├── TaskService.java
│   │   │           │   └── UserService.java
│   │   │           └── TeacherCloudApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── styles.css
│   │       │   ├── js/
│   │       │   │   └── scripts.js
│   │       │   └── images/
│   │       └── templates/
│   │           ├── index.html
│   │           ├── course/
│   │           │   ├── course-list.html
│   │           │   ├── course-detail.html
│   │           │   └── course-form.html
│   │           ├── event/
│   │           │   ├── event-list.html
│   │           │   ├── event-detail.html
│   │           │   └── event-form.html
│   │           ├── forum/
│   │           │   ├── forum-list.html
│   │           │   ├── forum-detail.html
│   │           │   └── forum-form.html
│   │           ├── task/
│   │           │   ├── task-list.html
│   │           │   ├── task-detail.html
│   │           │   └── task-form.html
│   │           └── user/
│   │               ├── user-list.html
│   │               ├── user-detail.html
│   │               └── user-form.html
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── teachercloud/
│       │           ├── controller/
│       │           │   └── CourseControllerTest.java
│       │           ├── service/
│       │           │   └── CourseServiceTest.java
│       │           └── TeacherCloudApplicationTests.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Instalación y Ejecución 🚀


## Contribuciones 🤝

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para contribuir.

## Licencia 📄

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
