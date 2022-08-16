import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

fun Project.configureNode() {
  tasks.withType(org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask::class.java).configureEach {
    args.addAll(
        listOf(
            "--network-concurrency",
            "1",
            "--mutex",
            "network"
        )
    )
  }

  // See https://youtrack.jetbrains.com/issue/KT-47215
  plugins.withType(YarnPlugin::class.java).configureEach {
    project.extensions.getByType(YarnRootExtension::class.java).apply {
      disableGranularWorkspaces()
      // Drop the patch version because there shouldn't be any dependency change
      lockFileDirectory = projectDir.resolve("kotlin-js-store-${project.getKotlinPluginVersion().substringBeforeLast(".")}")
    }
  }
}
