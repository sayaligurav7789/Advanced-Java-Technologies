# Servlet & JSP 

## 1. Introduction
This document provides a deep, instructor-style explanation of Java Servlets and JSP. It covers Servlets, JSP, EL, JSTL, Filters, MVC Architecture, JDBC, Deployment, Sessions, Cookies, and more.

---

## 2. What Are Servlets?
A **Servlet** is a Java class that runs on a server and handles HTTP requests. It allows Java to power dynamic web applications by:
- Receiving requests  
- Processing input  
- Interacting with databases  
- Sending responses back to the browser  

Static pages cannot handle logic alone—Servlets solve this by enabling dynamic, logic-driven behavior.

```mermaid
flowchart LR
    A[Client Browser] --> B[HttpServletRequest]
    B --> C[Servlet]
    C --> D[HttpServletResponse]
    D --> A
```

---

## 3. Understanding the Web (Request-Response Model)

The web operates using the HTTP protocol. When a user interacts with a website:
1. The browser sends an HTTP request.
2. The server receives it.
3. The corresponding Servlet processes it.
4. A response is sent back to the browser.

This entire cycle is managed by the **Servlet Container** (like Apache Tomcat).

```mermaid
sequenceDiagram
    participant B as Browser
    participant S as Server (Tomcat)
    participant SV as Servlet
    participant DB as Database

    B->>S: HTTP Request
    S->>SV: Forward Request
    SV->>DB: Query (optional)
    DB-->>SV: Data
    SV-->>S: Response
    S-->>B: HTTP Response
```

---

## 4. Installing Tools: Eclipse & Tomcat

### Eclipse IDE for Java EE  
Needed because it supports:
- Dynamic Web Projects  
- JSP editing  
- Automatic deployment  

### Apache Tomcat  
A web server + servlet container used to run your application.

### Steps to Configure in Eclipse:
1. Install Tomcat  
2. Open Eclipse → **Servers** tab  
3. Add new server → Select Tomcat  
4. Point to installation folder  

```mermaid
flowchart TD
    IDE[Eclipse IDE]
    Tomcat[Apache Tomcat Server]
    Browser[Web Browser]

    IDE -->|Deploy Project| Tomcat
    Tomcat -->|Serve Application| Browser
```

---

## 5. Creating a Dynamic Web Project

### Project Structure:
```
YourProject/
│
├── Java Resources/
│   └── src/ (Java files: Servlets)
│
├── WebContent/
│   ├── index.html / .jsp
│   ├── META-INF/
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/ (JAR dependencies)
```

```mermaid
flowchart TD
    A[Dynamic Web Project]
    B[src - Java Source Files]
    C[WebContent - HTML/JSP/CSS]
    D[WEB-INF - Protected Folder]
    E[web.xml - Deployment Descriptor]
    F[lib - External JAR Files]

    A --> B
    A --> C
    C --> D
    D --> E
    D --> F
```

---

## 6. Writing Your First Servlet

### Example:
```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello from Servlet!");
    }
}
```

```mermaid
sequenceDiagram
    participant H as HTML Page
    participant M as Mapping (web.xml / @WebServlet)
    participant S as Servlet

    H->>M: Request URL
    M->>S: Route to Servlet
    S-->>H: Response
```

---

## 7. Servlet Lifecycle

Servlets do not recreate themselves for every request.

1. `init()` – runs once  
2. `service()` – runs per request  
3. `destroy()` – runs at shutdown  

```mermaid
flowchart TD
    A[Servlet Loaded] --> B[init - Called Once]
    B --> C[service - Handles Requests]
    C --> D[Handles Multiple Requests]
    D --> E[destroy - Called on Shutdown]
```

---

## 8. Handling GET and POST Requests

### GET:
- Appends parameters to URL  
- Visible  

### POST:
- Sends data in body  
- More secure  

```java
String name = request.getParameter("username");
```

```mermaid
sequenceDiagram
    participant F as HTML Form
    participant R as Request Object
    participant S as Servlet

    F->>R: Send Data (GET/POST)
    R->>S: request.getParameter()
    S-->>F: Output Response
```

---

## 9. RequestDispatcher: Forward vs Redirect

### Redirect (`sendRedirect`)
- Creates new request  
- URL changes  

### Forward
- Internal server jump  
- No URL change  

#### Redirect:
```mermaid
sequenceDiagram
    Browser->>Server: Request A
    Server-->>Browser: sendRedirect(B)
    Browser->>Server: Request B
    Server-->>Browser: Response B
```

#### Forward:
```mermaid
sequenceDiagram
    Browser->>Server: Request A
    Server->>Servlet: Process
    Servlet->>JSP: Forward Internally
    JSP-->>Browser: Response
```

---

## 10. Cookies & Sessions

### Cookies:
```mermaid
flowchart LR
    Server -->|Set-Cookie| Browser
    Browser -->|Returns Cookie Each Time| Server
```

### Sessions:
```mermaid
flowchart LR
    Browser -->|JSESSIONID| Server
    Server --> SessionStore[Session Storage]
```

---

## 11. JSP – JavaServer Pages

JSP avoids print statements in servlets.

### Elements:
- Scriptlets  
- Expressions  
- Declarations  

```mermaid
flowchart TD
    JSP[JSP File] --> S1[Converted to Servlet]
    S1 --> C[Compiled]
    C --> R[Executed by Tomcat]
    R --> Output[HTML Output to Browser]
```

---

## 12. Expression Language (EL)
```jsp
${user}
```

```mermaid
flowchart LR
    A[Servlet Sets Attributes] --> B[Request or Session Scope]
    B --> C["JSP Uses `\${variable}`"]
    C --> D[Render Output]
```


---

## 13. JSTL
```mermaid
flowchart TD
    Servlet --> Data((Data))
    Data --> JSP
    JSP -->|JSTL Tags| Render[Rendered View]
```

---

## 14. MVC Architecture

```mermaid
flowchart LR
    Browser --> Controller[Servlet Controller]
    Controller --> Model[Model - Java Logic]
    Model --> Controller
    Controller --> View[JSP View]
    View --> Browser
```

---

## 15. Filters

```mermaid
sequenceDiagram
    participant B as Browser
    participant F as Filter
    participant S as Servlet

    B->>F: Request
    F->>S: doFilter() → Servlet
    S-->>F: Response
    F-->>B: Final Response
```

---

## 16. File Upload Handling

```mermaid
flowchart TD
    Form[HTML Form multipart/form-data] --> Parser[FileUpload Parser]
    Parser --> Servlet
    Servlet --> Storage[Save File on Server]
```

---

## 17. JDBC – Database Connectivity

```mermaid
flowchart TD
    Servlet --> JDBC[JDBC Driver]
    JDBC --> DB[(Database)]
    DB --> JDBC
    JDBC --> Servlet
    Servlet --> JSP
    JSP --> Client
```

---

## 18. Deployment Using WAR

```mermaid
flowchart TD
    WAR[WAR File Export] --> Tomcat[Tomcat Webapps Folder]
    Tomcat --> Extract[Extract WAR]
    Extract --> Run[Application Runs]
```

---
