package de.pfaffenrodt.workingtime.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.AutumnLeaf: ImageVector
    get() {
        if (_autumnLeaf != null) {
            return _autumnLeaf!!
        }
        _autumnLeaf = Builder(name = "Autumn-leaf", defaultWidth = 25.263.dp, defaultHeight =
                25.263.dp, viewportWidth = 25.263f, viewportHeight = 25.263f).apply {
            path(fill = SolidColor(Color(0xFF030104)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.362f, 9.69f)
                curveToRelative(0.0f, 0.0f, -0.75f, 1.108f, -1.068f, 0.0f)
                curveToRelative(-0.318f, -1.109f, -1.346f, -4.949f, -1.762f, -5.226f)
                curveToRelative(-0.417f, -0.278f, -0.417f, -0.278f, -0.417f, -0.278f)
                reflectiveCurveToRelative(-0.078f, 1.506f, -0.594f, 1.307f)
                curveToRelative(-0.515f, -0.198f, -4.313f, -2.217f, -4.63f, -2.652f)
                lineTo(6.574f, 2.444f)
                curveToRelative(0.0f, 0.0f, 0.355f, 3.328f, -0.515f, 2.615f)
                curveToRelative(0.0f, 0.0f, 1.113f, 2.771f, -2.573f, 3.048f)
                curveToRelative(0.0f, 0.0f, 1.186f, 3.087f, 4.552f, 4.75f)
                curveToRelative(0.0f, 0.0f, 1.148f, 1.783f, -0.949f, 1.503f)
                curveToRelative(0.0f, 0.0f, -2.932f, -0.395f, -3.325f, -0.752f)
                curveToRelative(0.0f, 0.0f, -1.548f, 3.01f, -3.764f, 3.128f)
                curveToRelative(0.0f, 0.0f, 2.656f, 1.504f, 2.337f, 4.156f)
                curveToRelative(0.0f, 0.0f, 5.107f, 0.041f, 4.911f, 0.832f)
                curveToRelative(-0.2f, 0.795f, -0.555f, 1.601f, -0.555f, 1.601f)
                reflectiveCurveToRelative(4.71f, -0.929f, 5.422f, -2.194f)
                curveToRelative(0.0f, 0.0f, 0.989f, 0.99f, 1.071f, 1.939f)
                curveToRelative(0.0f, 0.0f, 2.693f, -0.594f, 2.452f, -2.296f)
                curveToRelative(0.0f, 0.0f, 1.269f, 0.948f, 1.427f, 2.551f)
                lineToRelative(0.554f, -0.375f)
                curveToRelative(0.0f, 0.0f, -0.319f, -1.661f, -1.464f, -2.967f)
                curveToRelative(0.0f, 0.0f, -0.517f, -1.308f, 0.789f, -0.633f)
                curveToRelative(0.0f, 0.0f, 3.085f, 1.029f, 5.7f, -0.833f)
                curveToRelative(0.0f, 0.0f, -2.888f, -0.948f, -3.006f, -1.978f)
                curveToRelative(0.0f, 0.0f, 5.394f, -3.326f, 5.625f, -5.542f)
                curveToRelative(0.0f, 0.0f, -1.944f, 0.198f, -2.972f, -0.633f)
                curveToRelative(0.0f, 0.0f, -1.309f, -0.396f, 0.394f, -4.791f)
                curveToRelative(0.0f, 0.0f, -1.227f, 0.724f, -1.62f, -3.636f)
                curveToRelative(0.0f, 0.0f, -3.051f, 4.665f, -4.518f, 3.082f)
                curveTo(16.548f, 5.018f, 15.165f, 8.066f, 15.362f, 9.69f)
                close()
            }
        }
        .build()
        return _autumnLeaf!!
    }

private var _autumnLeaf: ImageVector? = null
