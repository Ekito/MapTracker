/**
 * This file is located under app/assets, so it is compiled
 * by Google Closure Compiler
 * see https://github.com/playframework/Play20/wiki/AssetsGoogleClosureCompiler
 * 
 */
function addKMLLayer(aMap, aKMLPath) {
	
	var layer = new OpenLayers.Layer.Vector(aKMLPath, {
        strategies: [new OpenLayers.Strategy.Fixed()],
        protocol: new OpenLayers.Protocol.HTTP({
            url: "/assets/kml/" + aKMLPath,
            format: new OpenLayers.Format.KML({
                extractAttributes: true,
                maxDepth: 2
            })
        })
    });
	
	aMap.addLayer(layer);
	
	return layer;
}

function moveMarker(aMap, aMarker, aId, aLon, aLat) {
	
	
    
    if (aMarker == null) {
    	aMarker = createMarker(aMap, aId, aLon, aLat);
    	
    } else {
    	// Google.v3 uses EPSG:900913 as projection, so we have to
        // transform our coordinates
        var newLonLat = new OpenLayers.LonLat(aLon, aLat).transform(
                new OpenLayers.Projection("EPSG:4326"),
                aMap.getProjectionObject());
    
	    var newPx = aMap.getLayerPxFromLonLat(newLonLat);
	    aMarker.moveTo(newPx);
    }
    
    return aMarker;
	
}

function createMarker(aMap, aId, aLon, aLat) {
	
	// Google.v3 uses EPSG:900913 as projection, so we have to
    // transform our coordinates
    var newLonLat = new OpenLayers.LonLat(aLon, aLat).transform(
            new OpenLayers.Projection("EPSG:4326"),
            aMap.getProjectionObject());
	
	var size = new OpenLayers.Size(32,37);
    var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
    var icon = new OpenLayers.Icon('/assets/images/map-marker.png',size,offset);
    var marker = new OpenLayers.Marker(newLonLat,icon);
    marker.map = aMap;
    marker.id = aId;
    
    aMap.getLayer("Markers").addMarker(marker);
    
    return marker;
	
}

function initMap() {
	
	var map = new OpenLayers.Map("map", {
				numZoomLevels: 19
			});
	
	var gsat = new OpenLayers.Layer.Google(
	        "Google Satellite",
	        {type: google.maps.MapTypeId.SATELLITE}
	    );
	map.addLayer(gsat);
    
    addKMLLayer(map, "bdx_buildingshape.kml");
    addKMLLayer(map, "bdx_emergencyroadshape.kml");
    addKMLLayer(map, "bdx_periphroadshape.kml");
    addKMLLayer(map, "bdx_rwyshape.kml");
    addKMLLayer(map, "bdx_servroadshape.kml");
    addKMLLayer(map, "bdx_standshape.kml");
    
    var markers = new OpenLayers.Layer.Markers( "Markers" );
    markers.id = "Markers";
    map.addLayer(markers);
    
    // Google.v3 uses EPSG:900913 as projection, so we have to
    // transform our coordinates
    map.setCenter(new OpenLayers.LonLat(-0.712, 44.83).transform(
        new OpenLayers.Projection("EPSG:4326"),
        map.getProjectionObject()
    ), 14);
    
    // list layers
    $.each(map.layers, function(index, value) { 
    	$('#layersForm').append('<label class="checkbox"><input type="checkbox" value="' + index + '" checked> ' + value.name + '</label>');
    });
    
    // add a click listener on each layer checkbox
    $("#layersForm input:checkbox").change(function() {
    	  var target = $(this);
    	  map.layers[target.prop("value")].setVisibility(target.prop("checked"));
    	  
    });
    
    return map;
	
}