package com.gov.erf.models.action;

public enum MovementActionType {

    REGISTER, // регистрация заявки
    ORGAN_REJECT, // Отказ заявки ( ответственный орган )
    ORGAN_ACCEPT, // Принятие заявки ( ответственный орган )
    OPERATOR_REJECT, // Отказ заявки ( оператор )
    OPERATOR_ACCEPT, // Принятие заявки ( оператор )
    COMMISSION_REJECT, // Отказ заявки ( комиссия )
    COMMISSION_ACCEPT, // Принятие заявки ( комиссия )
    CONSIDERATION_BY_COMMISSION, // На рассмотрении комиссией
    RESOLUTION_BY_COMMISSION // Решение комиссии

}
