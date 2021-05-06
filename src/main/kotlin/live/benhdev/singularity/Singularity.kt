package live.benhdev.singularity

import com.jagrosh.jdautilities.command.CommandClientBuilder
import com.jagrosh.jdautilities.commons.waiter.EventWaiter
import live.benhdev.singularity.commands.WhoisCommand
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import java.nio.file.Files
import java.nio.file.Paths

class Singularity {

    companion object {

        /**
         * Loads all of the default information for the bot
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val config: List<String> = Files.readAllLines(Paths.get("config.txt"))

            val eventWaiter = EventWaiter()
            val client = CommandClientBuilder()

            client.useDefaultGame()
            client.setOwnerId(config[1])
            client.setPrefix(";")

            client.addCommands(
                WhoisCommand()
            )

            val jdaBuilder = JDABuilder.createDefault(config[0])
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.listening("loading..."))
                .addEventListeners(eventWaiter, client.build())

            jdaBuilder.build()
        }
    }
}