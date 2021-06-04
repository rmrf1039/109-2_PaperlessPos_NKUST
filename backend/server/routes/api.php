<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\Api\ReceiptController;
use App\Http\Controllers\Api\CouponController;

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::apiResources([
    'receipt' => ReceiptController::class,
    'coupon' => CouponController::class,
]);