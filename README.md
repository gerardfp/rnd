# rnd

```mermaid
erDiagram
  AGENDA ||--o{ CONTACTE : te
  CONTACTE ||--o{ INFO : te
  
  AGENDA {
    string titol
  }
  
  CONTACTE {
    string nom
  }
  
  INFO {
    string descripcio
    string valor
  }
```
