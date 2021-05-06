package live.benhdev.singularity.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import live.benhdev.singularity.utils.CustomEmbedBuilder
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.MessageEmbed

class WhoisCommand : Command() {
    /**
     * Handles the logic for the whois command
     */
    override fun execute(event: CommandEvent) {
        if (event.message.mentionedMembers.size > 0) {
            event.message.mentionedMembers.forEach { event.message.reply(create(it)).queue() }
        } else {
            event.message.reply(create(event.member)).queue()
        }
    }

    private fun create(member: Member): MessageEmbed {
        val embed = CustomEmbedBuilder()
        val rolesMentioned = member.roles.map { it.asMention }.joinToString { it }
        val permissions = member.permissions.map { it.name }.joinToString { "`$it`" }

        embed.setThumbnail(member.user.effectiveAvatarUrl)
        embed.addField("Join Date", member.timeJoined.toString(), true)
        embed.addField("Registration Date", member.user.timeCreated.toString(), true)
        embed.addField("Roles [${member.roles.size}]", rolesMentioned, false)
        embed.addField("Key Permissions [${member.permissions.size}]", permissions, false)
        embed.setAuthor(member.user.asTag, null, member.user.effectiveAvatarUrl)
        return embed.build()
    }

    init {
        name = "whois"
        help = "Gives you information about a user"
    }
}