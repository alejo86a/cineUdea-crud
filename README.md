# cineUdea-crud

Java EE web application for managing a movie theater ("cine") business: movies, showtimes, theaters, rooms, seats, pricing, tickets, reservations, users, and comments, generated largely via NetBeans' JSF CRUD scaffolding.

## What it does

Provides full CRUD (Create/Read/Update/Delete) screens for the main entities of a cinema management domain, including:

- Movies, genres, languages, ratings ("clasificacion"), formats
- Cinemas, theaters ("sala"), seats, municipalities/locations
- Billboard/listings ("cartelera"), showtimes ("funcion", "programacion")
- Tickets ("boleta"), reservations, pricing, users, and comments

Both a desktop web UI (`web/`) and a mobile-oriented UI (`web/mobile/`) are included, built with JSF + PrimeFaces components.

## Tech stack

- Java EE (JSF, EJB-style session facades, JPA via `persistence.xml`)
- PrimeFaces component library
- NetBeans project structure (`build.xml`, `nbproject/`)
- Relational database via JPA (configured in `src/conf/persistence.xml` and `setup/sun-resources.xml`, e.g. GlassFish JNDI resources)

## Running it

Requires a Java EE application server (e.g. GlassFish/Payara) and a configured datasource matching `setup/sun-resources.xml`. Build with Ant/NetBeans (`build.xml`) and deploy the resulting WAR.

## Context

University coursework project for the Software Architecture course at Universidad de Antioquia (semester 2015-2). A CRUD exercise generated mostly from JPA entities using NetBeans tooling, not a production application.
