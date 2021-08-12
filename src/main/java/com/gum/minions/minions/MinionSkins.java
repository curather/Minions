package com.gum.minions.minions;

import com.gum.minions.util.Utils;
import net.minecraft.item.ItemStack;

public enum MinionSkins {
    SKELETON_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmI0Yzg2OWI5YzBmYmE1OTJjOTY4NTQ0ZmM1MTFkNTdkYmFmNzU3Zjg0YzY0NWNkYWM0MDgzYjQzNjI4Mzk1MSJ9fX0=",
                     "99f9ffee-cb7d-4532-8fa5-4859ce386fcf"),
    ZOMBIE_MINION(  "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZThmZmY2NzQ1ODdmNjEwOTRjMzE5NmFiZDU2NWI0NGQ4MDZkNzU3NDA1YTZkMjY2MWE3Yjc5N2MxMTQ0YjZhNCJ9fX0=",
                     "9d16b331-fda2-4adf-8aa0-93912ee5b399"),
    ACACIA_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM1ZDg3NzU4ZDgxOWFlNGQwZWE0N2MyODRhOWYxMDI2YWJhYTc0ZjUxZjk1N2E0NTkwMTgyYmE4MDRkZjEyYSJ9fX0=",
            "8d1f1bd8-78c8-4609-900d-588d44856f2b"),
    BIRCH_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDUzOGQzMjRjYzNhYzA2YWRiOWJkYjJhYzJkMWJkNGNhM2ZjNDQ3ZjRkZTNjMDM4OGY2MTVmYzZlZDBhYWY2OCJ9fX0=",
            "f4c3a6db-6849-42a6-8949-b2e863ae880d"),
    DARKOAK_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjkwOWRkYTU0MGQwMmMzYWI5YWM3ZWRiMjExYjJkOTFjNjNkYjQwY2ZlZWNlNWQzMTU2YTg4ZTQzZTQwYzM1MCJ9fX0=",
            "693d8d2e-b63f-43eb-ab17-6af4dd3cef3e"),
    JUNGLE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFhMzVlOGJlMmI5NTI1NmQyOTQzNjc0Njk4ZTdlYWMwMjBhYWY4MWE2ZjZiNzJjOTkyYzQ3MzRkNTFhNzI2MiJ9fX0=",
            "c7c67777-e43f-48b1-9864-69236eede139"),
    OAK_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzIzZTBiYmYwN2FmZGE0OGYyMmM3OWJjZDYyNDk0MWY0YWI3ZmJlZjE5NWI0MjFkOWFjNDJhNWY4MjExYTk0MiJ9fX0=",
            "e0165ef9-814e-45dd-93b2-8d61b9c9a99c"),
    SPRUCE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzIzZTBiYmYwN2FmZGE0OGYyMmM3OWJjZDYyNDk0MWY0YWI3ZmJlZjE5NWI0MjFkOWFjNDJhNWY4MjExYTk0MiJ9fX0=",
            "e0165ef9-814e-45dd-93b2-8d61b9c9a99c"),
    COAL_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU3MDVjZjg2NGRmMmMxODJlMzJjNDg2YjcxNDdjYmY3ODJhMGFhM2RmOGE2ZDYxNDUzOTM5MGJmODRmYjE1ZCJ9fX0=",
            "4f366780-53d3-436e-b486-72371d60513c"),
    COBBLESTONE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjljMzhmZTRmYzk4YTI0ODA3OWNkMDRjNjViNmJmZjliNDUwMTdmMTY0NjBkYWIzYzM0YzE3YmZjM2VlMWQyZiJ9fX0=",
            "40b8ab14-a9c5-479a-8900-1bc47c579e02"),
    DIAMOND_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmRiMDA4MDY4ODIzODQ0ZDEyOWVmZDgzOWM4MzA2NTBkOThlZWE4MTA0Y2YyYjMyNmE5YmU3ZGZiMTdhYjk5ZCJ9fX0=",
            "0cce2d46-93e5-4349-bbea-df8b0c994fac"),
    EMERALD_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVlYTU0YTc1MjAxZDY0NWIyMGNiMzRhMmExNTVkYjU0YTkyMzhmYTBiOWQ5MjVmYTNhMmRkYzA2NmFmMjdjOSJ9fX0=",
            "10161c2f-ce03-4d12-b827-6eae78db3d04"),
    GLOWSTONE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTFmNGYwOTY5NjY4YzM2ZThiNzM5ODE2NWViY2YyYTEzM2NhODhiMmI4YjNiZTZlOWM2Mzg0MzIwZmZiMTUwNyJ9fX0=",
            "b2766011-e654-4ef0-8fdb-84971390b975"),
    GOLD_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTkwODIzNWExY2JlY2MwM2E3MmNkZjcxMGY0ZWQ1MTlkNjViNGRhNjJiNTRhNGVmOThhNzQwOGZjZjUxYjgzYiJ9fX0=",
            "b53dbef1-d2cd-43ab-8ffa-054c5903e1d3"),
    GRAVEL_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGEzNzAwODk2MTE3ZmQ5NDg4OWIwMjE2ZDEyNGYxZTY3ZTRmMGU5Y2EzYjA0ZDE2OGY4NDlhMjk3YmUyMDQ3ZCJ9fX0=",
            "f546bcfd-ec01-4421-b6ed-871c63cda08d"),
    IRON_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTczMDkyY2FlYTg5ZGQxMmQzNjgzNzVmMWEwOTc3OTZlM2JjODhmODA5YWNjZjMyMDcwNmJkYzA0OGNkNGM1ZSJ9fX0=",
            "7c562273-3d61-4a13-978c-183e65dc43bf"),
    LAPIS_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY1NGEwZjhhODVkMTMxYWM5ZTYzMzc3NjgzN2Q5MzFmMGE5NTJkY2YxNzRjMjg5NzI3ODhmZWYzNDM5MTdlZCJ9fX0=",
            "b34bc9a4-794b-4d21-80ca-1529d76f1847"),
    NETHERITE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTA2ZTgwMWZkMTJlMjFjYTFlNWNhZDg0NDljODVkNjI3YWFhMzQxZTA3Y2EyNzAyODc4YjhlZjBmNThlNmE3ZSJ9fX0=",
            "f83f6698-d490-47af-9e1f-609ae430f71"),
    OBSIDIAN_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDYzMGVhZTU5NzQ1MTgyNjAxOTdlNTY4MzdmMzJhMjU1OTBjMzk1YzU0Yzk1MzQxOWY2NzE5MzFlNTc2ODVmZSJ9fX0=",
            "b315795b-d97a-4a2a-a046-da1eaddbc02b"),
    QUARTZ_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmU3MmJlMWY3OTFkOTIzOTVjNGNmMDEzMzVkMDc4ZGU1YWY0M2Q5YzZmY2JjM2EzODc1M2RjNTY5NDJmNGE0NiJ9fX0=",
            "f4f7f3d3-4244-404e-a93b-1f886d7dee70"),
    REDSTONE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWUyMWY4Y2ZlOGNjMGUwODk5MGQ1MjE2NWU3OGU2ZjgxNmY0ZjhlMWNlN2NiMGYwYTZjOGViZTFkYTg1ZTQyYSJ9fX0=",
            "cd9d73a3-38e8-4c13-8e7f-49928d36c538"),
    SAND_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmEyMjBlMzhiYTI1NTVlOWNkZDYyMmMzMDg0MDc1MjM5ODcyOWI1Y2E0ZTQ5NzdlMTk5N2U0MWYyOTliNTA4MSJ9fX0=",
            "5d7474ab-eb45-4fdd-b952-61926a0e85e1"),
    ICE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGYxMmJmNzY4MTFkZjJjMDIwY2VjZDM0Y2Q4ZDFmMmFlZDI4YTU2MDY3NDMyODEzMGQyZDM1YTBlOWI1YzdiOSJ9fX0=",
            "642502fc-aa59-46c4-8e57-6956961ee500"),
    SNOW_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjZkMTgwNjg0YzM1MjFjOWZjODk0NzhiYTQ0MDVhZTljZTQ5N2RhODEyNGZhMGRhNWEwMTI2NDMxYzRiNzhjMyJ9fX0=",
            "e4970613-5a38-48bd-ac9b-af42cb15657c"),
    SPIDER_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWJjMzEwNDM5MjU5MzA3MThiM2NjNzQzMmViMjIzMmM1MzRiNmNhZjk1YzBkYmVjZTg0YWRmN2E1NGM5ZjllNCJ9fX0=",
            "3ae50db9-2fb5-4cb1-891a-aa796d6cfd3f"),
    CAVE_SPIDER_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA0MGM2MTYyYjY3Y2Y3NWQ4OTE1NDdkNzRhNjc5YmNjMGRlOGFkZTEzOTNiNDg3NGY1NGE3ZDRiNzdkMTk4NiJ9fX0=",
            "13a83c16-3d63-461e-99b7-fbb6fe901bbd"),
    CREEPER_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY4YzEyODE5YjEzNzIzOTk5MDVjZTA1Y2FmNjNmODBjNjliM2Y4M2U2ODBiYmY2M2Y4MTMzODljZTllN2MzZSJ9fX0=",
            "48c0609b-9e94-4a43-9e81-9a039ae4ec4e"),
    ENDERMAN_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY4ODM2MmM2Yzk5NTFmN2RkMzExOWY5OWU1OGE3YzJhNzczNzA0NDhmNjFiMmY1MzAwOGIyMWU1ZjY1YWU5NyJ9fX0=",
            "c00315ef-35a7-410a-93e9-ef0fa9420f74"),
    GHAST_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY3YzVhNmQ1MGEwN2RkYjZmOWUyMWE2M2YwMDJhMGE1MzI0OWVkZjczMjg1MDI5Y2EyZDEwNjA5YTkyYWJmOSJ9fX0=",
            "0a1e5f3c-67d8-4b1f-bcdf-cbb2ca43ae13"),
    SLIME_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGJjOTY5ZWViM2QxMzAxMWE3OTc1NWFjYjQ5NWUyMTJkMWUzNGYwM2E4NjhmMWUyMjc3YTY0YWNlMDIzMmM1MSJ9fX0=",
            "fb29b260-7ea9-4589-b955-c8be455399cf"),
    BLAZE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDNmMzJlYmRjMDQ2Njc1YTkzNmYyMTQxNjRkYmQzYzJmYmQyZTg0YjRiZGU3Mzc0ODNhZWNkOWJiYmNiMDNmMSJ9fX0=",
            "8fb437ff-0dae-427e-ab58-199359506f2c"),
    MAGMA_CUBE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE5ZDQwYjgyN2M4ZDI0NDIyNmU4MzE5YjEzMjZjOWRmY2U0MmZkZmRhNGI2ZDAwZmJiYTMwZTg0OGIyNTBiOSJ9fX0=",
            "69f86586-d28c-4e14-bee7-bf393b5c196a"),
    END_STONE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzk5NGJlM2RjZmJiNGVkMGE1YTc0OTViNzMzNWFmMWEzY2VkMGI1ODg4YjUwMDcyODZhNzkwNzY3YzNiNTdlNiJ9fX0=",
            "732031ef-ad9a-4f1a-90c0-6e3dcba99276"),
    RABBIT_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZmODM3YTEzMDM3MjUzZmVhODljNjUzODJlMjQ4YTM2N2Y5OTM0M2M4YzZkZmQyZjEzYzYzNDRhYTM4MjVkNSJ9fX0=",
            "e0c7c17c-eba7-4541-8d37-b40034f40388"),
    SHEEP_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTRlMmFjOWM0YmFhODI0YThiMTY2ZTI4N2ZkOWViZTdmMGRkMWJhZDQ0OWY5NTFhMTg5Y2M3NTM3ODJmNzhmMyJ9fX0=",
            "71d98de3-89bb-468b-8558-2f0c58407d93"),
    CHICKEN_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWIyNDYzZWI4ZmE4YTYwMTdjNjE4Y2QyZjc1YjAyYzRjYzA4ZWE1NjUxNTRjN2I0ZDJkMDE3NGEwNTBkM2FkYiJ9fX0=",
            "81594401-1e2e-405c-bab5-ed9a8da51134"),
    PIG_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I5YjMwM2Q2Yzc5MjU4NWUxYmQwNGQxMzIwODE2YWFmZTQ3ZGI2NzU1YTEzM2MzMWIzY2M3OTQwOTFhMzMwNiJ9fX0=",
            "5007603e-4214-42fb-b2dc-2db801dd615f"),
    COW_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRmZjBmNThjMmYyY2RjNzQyMzQwYTdhNzFlYjEzYmU5MjhiZmY2M2FmZjgzMzAwMmE0N2I3NDZiOTZiNDQ4OCJ9fX0=",
            "33147baf-ea65-42fc-a207-9d6939ad906f"),
    SUGAR_CANE_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTdjMjlkZjBiODliMGY0ZTZmMWYzNmYxZjc0Njg4Zjc4NDAzZGJlNTQxN2I1MjAzZTM5NjllZWI0MjI2NThjNSJ9fX0=",
            "73d00036-57ec-4995-a7d7-46ce9f859e8e"),
    CACTUS_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZlYzg3YWIyNjUxZTc3MDM4ZGMwOTA0MTA2ZjQyYzM4ZTk5ZTE1YzhmYjM3YjExMDQ5ZTAzYmE1ZGRlMzU4MCJ9fX0=",
            "f0af4378-927d-437b-9693-5a19e87bd5a7"),
    COCOA_BEANS_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjc0ZTI0MjQyNTc1MWM2OGYyNTkzNjM5NjE5YWUxZGE5N2JiYjc1MjgwYzQxZGYyYjVlOGQ5ZjhjZjY4Y2U2MyJ9fX0=",
            "12ea9759-0482-49bf-9c94-abc559352f19"),
    MUSHROOM_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgyM2U1YTI4YzgzZGI1YjRkMjVkYmE3NjMxZjFiYTEzOTc1Y2I0ZTBiOGE1NzIwMDI1NDk1OTllZmExZGRkNSJ9fX0=",
            "84c8113f-3155-4aa1-a3c1-5676ebe1e788"),
    MELON_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWIwN2NhMTRjYjE1ZjYxMzM4OWMyMjgzNTFjZDM3M2I4OTkyMGE5ZGFjZmY0YjQ4YWZhMzZmNzZlNzg2YjlhNSJ9fX0=",
            "aeee03c0-826f-457b-81b0-e38a11870dc4"),
    PUMPKIN_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGVmMGU2MjRmNDhkZTc0MThhZmJkMzY1ZjA4NDRmOTIxOGQ3ZmIzY2JlOTUyOGEzMDEzYWQ2Njc1YTRmMjlhMiJ9fX0=",
            "7dbdda21-952b-4f70-8498-e8db91aec181"),
    POTATO_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjQzZTlmOGMwMjY2YzhjZTkyYzBkM2JhODkzODIyMTI3ZWJiN2U2MzhmMjg3ZjM2OWE3NWJiOWJmYWM3NWFiZCJ9fX0=",
            "da5170b5-d034-4131-86dd-eaa546dd81b7"),
    CARROT_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWQ3M2MzMDA1N2E4N2JkMGUwNTdmOTQxNGY5M2I3M2Q5MDc5MWU3NWRjZjIxNTRkOTRkZGJjNDYwOTU0Yzg4NCJ9fX0=",
            "9edeb829-a4cb-4574-a7e2-db74ff2ec189"),
    WHEAT_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNkZWYyNTI0ZTA2MjU0NzBlYmRmYTUyZDJlMGUzM2ZiOWJjYjI1NjgyZGUwOWZiNjljZWY5NmM5OWZjYTEyZiJ9fX0=",
            "2bf4642c-d934-4ff7-ba62-ffbb532c0bec"),
    NETHER_WART_MINION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI1OGUxYzhmN2U2ZWJiMzYyMmM2NmE1MjFiN2Y4MzhjY2VlOGFhOTI0MjU4YmIzMjYzMzU2Zjk5NzI1YWM1MyJ9fX0=",
            "2653c2bf-3588-4c24-9121-d8953a372c19");


    private final String Texture;
    private final String oldId;

    MinionSkins(String tex, String id) {
        this.Texture = tex;
        this.oldId = id;
    }

    public ItemStack playerHead() {
        return Utils.getTexturedHead(this.Texture,this.oldId,1);
    }

    public String returnTexture() {
        return this.Texture;
    }

    public String returnId() {
        return this.oldId;
    }
}