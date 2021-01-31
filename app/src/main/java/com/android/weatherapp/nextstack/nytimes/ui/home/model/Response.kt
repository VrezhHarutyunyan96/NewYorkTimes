package com.android.weatherapp.nextstack.nytimes.ui.home.model

import com.squareup.moshi.Json

data class NewsResponseModel(

    @Json(name = "results")
    val results: List<ResultsItem?>? = null,

    ) {
    data class ResultsItem(

        @Json(name = "per_facet")
        val perFacet: List<String?>? = null,

        @Json(name = "eta_id")
        val etaId: Int? = null,

        @Json(name = "subsection")
        val subsection: String? = null,

        @Json(name = "org_facet")
        val orgFacet: List<String?>? = null,

        @Json(name = "nytdsection")
        val nytdsection: String? = null,

        @Json(name = "column")
        val column: Any? = null,

        @Json(name = "section")
        val section: String? = null,

        @Json(name = "asset_id")
        val assetId: Long? = null,

        @Json(name = "source")
        val source: String? = null,

        @Json(name = "abstract")
        val jsonMemberAbstract: String? = null,

        @Json(name = "media")
        val media: List<MediaItem?>? = null,

        @Json(name = "type")
        val type: String? = null,

        @Json(name = "title")
        val title: String? = null,

        @Json(name = "des_facet")
        val desFacet: List<String?>? = null,

        @Json(name = "uri")
        val uri: String? = null,

        @Json(name = "url")
        val url: String? = null,

        @Json(name = "adx_keywords")
        val adxKeywords: String? = null,

        @Json(name = "geo_facet")
        val geoFacet: List<String?>? = null,

        @Json(name = "id")
        val itemId: Long? = null,

        @Json(name = "published_date")
        val publishedDate: String? = null,

        @Json(name = "updated")
        val updated: String? = null,

        @Json(name = "byline")
        val byline: String? = null
    )

    data class MediaItem(

        @Json(name = "copyright")
        val copyright: String? = null,

        @Json(name = "media-metadata")
        val mediaMetadata: List<MediaMetadataItem?>? = null,

        @Json(name = "subtype")
        val subtype: String? = null,

        @Json(name = "caption")
        val caption: String? = null,

        @Json(name = "type")
        val type: String? = null,

        @Json(name = "approved_for_syndication")
        val approvedForSyndication: Int? = null
    )

    data class MediaMetadataItem(

        @Json(name = "format")
        val format: String? = null,

        @Json(name = "width")
        val width: Int? = null,

        @Json(name = "url")
        val url: String? = null,

        @Json(name = "height")
        val height: Int? = null
    )

}

