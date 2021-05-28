package com.gov.erf.models.action;

public enum MovementActionType {

    REGISTER, // регистрация заявки
    RESPONSIBLE_ORGAN_REJECT, // Отказ заявки ( ответственный орган )
    RESPONSIBLE_ORGAN_ACCEPT, // Принятие заявки ( ответственный орган )
    AUTHORIZED_ORGAN_REJECT, // Отказ заявки ( уполномоченный орган )
    AUTHORIZED_ORGAN_ACCEPT, // Принятие заявки ( уполномоченный орган )
    COMMISSION_REJECT, // Отказ заявки ( комиссия )
    COMMISSION_ACCEPT, // Принятие заявки ( комиссия )
    CONSIDERATION_BY_COMMISSION, // На рассмотрении комиссией
    RESOLUTION_BY_COMMISSION // Решение комиссии

}
