package live.benhdev.singularity.db.objects

import org.jetbrains.exposed.dao.id.IntIdTable

object GuildObject : IntIdTable() {
    val guildid = long("guild_id")

}