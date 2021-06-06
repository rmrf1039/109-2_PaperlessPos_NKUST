<?php

namespace App\Http\Controllers\Api;

use App\Models\Coupons;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Response;
use Illuminate\Support\Str;

class CouponsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
	    $seller_id = $request->seller_id==null ? null:$request->seller_id;
	    if ($seller_id){
		$coupons = Coupons::where('seller_id',$request->seller_id)
						    ->get();
	    }else{
	    $coupons = Coupons::get();
	    }
        return response(['coupons' => $coupons], 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
	    $coupon = Coupons::create($request->all());
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
