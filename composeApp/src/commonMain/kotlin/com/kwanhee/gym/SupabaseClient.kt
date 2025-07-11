package com.kwanhee.gym

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = Key.SupabaseUrl,
        supabaseKey = Key.SupabaseKey
    ) {
        install(Postgrest)
    }
}
