<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\Api\ReceiptController;
use App\Http\Controllers\Api\CouponsController;

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::apiResources([
    'receipts' => ReceiptController::class,
    'coupons' => CouponsController::class,
]);