plugins {
    application
}

dependencies {
    implementation(project(":db1"))
    implementation(project(":db2"))
}

ksp {
    arg("komapper.metaObject", "example.app.Meta0")
}

application {
    mainClass.set("example.app.MainKt")
}
