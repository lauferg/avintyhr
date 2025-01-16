# Avinty HR Application

Java backend to provide an API for managing employees and appointments.

## Requirements

PostgreSQL database version 17. See application.properties, by default the program looks for it on localhost:5432.

Check `application.properties` to make sure settings and credentials observe running environment.

>⚠️ The update script and the database diagram required by the assignment can be found in the `operations` folder.

## Work log

| Work                                      | Effort in minutes | Notes                                                                                                                                                                                                                          |
| :---------------------------------------- | ----------------: | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Planning DB, diagram                      |                60 | Initially overengineered with tables like Address for locations and other tables the specifications did not ask for. Had to cut it back.                                                                                       |
| DB implementation with Liquibase          |               180 | Will probably go much faster in the future.                                                                                                                                                                                    |
| Skimming through Liquibase documentations |                90 | Seen better documentations and community support. Also seen a lot worse, though.                                                                                                                                               |
| Skimming through MapStruct documentations |                40 | Very nice tool, why haven't I seen this used anywhere else?                                                                                                                                                                    |
| Chasing Liquibase error                   |               180 | Liquibase swallowed a typo. Me using Liquibase for the first time + this = wasted evening. (Wrote changest instead of changeset, liquibase just ate it without errors but did not do the changes where this typo was present.) |
| Skeleton Spring project                   |                15 | Added Liquibase dependency independently in the end. Only Java 17 was available on the initializer page.                                                                                                                       |
| Basic CRUD endpoints                      |               280 | Created repositories, entities, controllers and services. Liquibase errors about missing changelog. Liquibase error about void <init()> method missing. Ironed out some kinks working with MapStruct for the first time.       |
| Custom exception handling                 |                10 | Very ugly. Given more time it would have been nice for this solution be an absolute last result and have more controller advice for different kinds of exceptions.                                                             |
