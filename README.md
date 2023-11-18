# rag-something-story

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can ingest your own documents by entering their URLs in [application.properties](src/main/resources/application.properties).
```properties
rag.something.story.documents.sources[0]=file://${HOME}/projets/personnels/java/quarkus/rag-something-story/src/main/resources/kevin-nzuguem-story.txt
rag.something.story.documents.sources[1]=file://${HOME}/projets/personnels/java/quarkus/rag-something-story/src/main/resources/cv-kevin-nzuguem.pdf
```

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
Some examples of requests : 
- [quelles sont les villes dans lesquelles Kevin NZUGUEM a fréquenté?](http://localhost:8080/something/story?message=quelles%20sont%20les%20villes%20dans%20lesquelles%20Kevin%20NZUGUEM%20a%20fr%C3%A9quent%C3%A9?)
- [quelles sont les langages de programmation avec lesquelles Kevin NZUGUEM à travailler?](http://localhost:8080/something/story?message=quelles%20sont%20les%20langages%20de%20programmation%20avec%20lesquelles%20Kevin%20NZUGUEM%20%C3%A0%20travailler?)
- [une courte histoire que Kevin NZUGUEM](http://localhost:8080/something/story?message=une%20courte%20histoire%20que%20Kevin%20NZUGUEM)

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rag-something-story-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
