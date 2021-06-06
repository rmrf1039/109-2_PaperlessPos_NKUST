<?php

namespace App\Http\Controllers\Api;

use App\Models\Coupons;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Str;
use Response;

class CouponsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        if ($request->carrier) {
            if ($request->seller_id){
                $coupons = Coupons::where('seller_id', $request->seller_id)
                                ->where('carrier', $request->carrier)
                                ->get();
            }else{
                $coupons = Coupons::where('carrier', $request->carrier)
                                ->get();
            }

            if (count($coupons) == 0) {
                return response(['code' => 9002, 'error' => 'no record'], 200);
            }
    
            return response(['coupons' => $coupons], 200);
        }

        return response(['code' => 9001, 'error' => 'missing argument(carrier)'], 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $uuid = array("uuid" => Str::uuid());
	    $coupon = Coupons::create(array_merge($uuid, $request->all()));
    	return response($coupon, 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Coupons  $coupon
     * @return \Illuminate\Http\Response
     */
    public function show(Coupons $coupon)
    {
        return response($coupon, 200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Coupons  $coupon
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Coupons $coupon)
    {
        $coupon->update($request->all());
        return response($coupon, 200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Coupons  $coupon
     * @return \Illuminate\Http\Response
     */
    public function destroy(Coupons $coupon)
    {
        $coupon->delete();
        return response(null, 204);
    }
}
