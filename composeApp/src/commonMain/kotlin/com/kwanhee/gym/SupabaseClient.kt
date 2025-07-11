package com.kwanhee.gym

import com.kwanhee.gymapp.const.ApiKeys
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://qhgkskqotndjcaadvstx.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InFoZ2tza3FvdG5kamNhYWR2c3R4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTE3NjkwNTUsImV4cCI6MjA2NzM0NTA1NX0.ZM_xKmUddGDMCJBdwGhVXofoueh8J1__H5OpoFkKEqY"
    ) {
        install(Postgrest)
    }
}
