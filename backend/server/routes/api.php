<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\Receipt;
use App\Http\Controllers\Coupon;

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::apiResources([
    'receipt' => Receipt::class,
    'coupon' => Coupon::class,
]);