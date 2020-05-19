package ua.nure.makieiev.ark.util.converter

interface Converter<DTO, RESPONSE> {

    fun fill(any: DTO): RESPONSE

}