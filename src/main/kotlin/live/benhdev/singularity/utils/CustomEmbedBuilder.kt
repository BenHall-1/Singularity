package live.benhdev.singularity.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color

class CustomEmbedBuilder : EmbedBuilder() {
    override fun build(): MessageEmbed {
        setColor(Color.WHITE)
        setFooter("Singularity | Created & Maintained by Ben#2028")
        return super.build()
    }
}