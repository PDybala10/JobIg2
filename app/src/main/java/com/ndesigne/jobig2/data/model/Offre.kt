package com.ndesigne.jobig2.data.model

import com.google.gson.annotations.SerializedName;

class Offre {

    @SerializedName("id")
    var id: String? =null
    @SerializedName("type")
    var type: String? =null
    @SerializedName("url")
    var url: String? =null
    @SerializedName("created_at")
    var created_at: String? =null
    @SerializedName("company")
    var company: String? =null
    @SerializedName("company_url")
    var company_url: String? =null
    @SerializedName("location")
    var location: String? =null
    @SerializedName("title")
    var title: String? =null
    @SerializedName("description")
    var description: String? =null
    @SerializedName("how_to_apply")
    var how_to_apply: String? =null
    @SerializedName("company_logo")
    var company_logo: String? =null

}
