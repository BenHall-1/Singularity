# Singularity Discord Bot

# Features

- Strike System
- Web Panel (**All feature available on panel**)
- Whitelabeled bot?

# Potential Issues

- Saving all messages from Discord (For logging)
    - *Can probably be solved by implementing a way to turn it off by default*

# Database Stuffs

- MongoDB / MySQL ?? 
- Per-Guild settings
- i18n in database
    - Potentially cache the strings until language reload is ran?
- Accessible via web panel
- Place to store logs
- Place to store users (for web panel) - Check discord TOS
- Is it quicker to pull from DB than discord? are there issues with this? 

## Tables

- users
- guilds
    - guild_settings
- languages
    - i18n_strings
- logs_chat
- logs_mod
- 