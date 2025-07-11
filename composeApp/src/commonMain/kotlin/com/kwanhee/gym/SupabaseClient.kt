package com.kwanhee.gym

import com.kwanhee.gymapp.const.ApiKeys
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = ApiKeys.supabaseUrl,
        supabaseKey = ApiKeys.supabaseKey
    ) {
        install(Postgrest)
//        install(GoTrue)
    }
}
